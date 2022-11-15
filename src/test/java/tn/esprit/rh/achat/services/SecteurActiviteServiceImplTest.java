package tn.esprit.rh.achat.services;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class SecteurActiviteServiceImplTest {

    @Mock
    SecteurActiviteRepository secteurRepo;

    @InjectMocks
    SecteurActiviteServiceImpl secteurService;

    @Test
    public void retrieveSecteurActiviteTest(){
        SecteurActivite s = new SecteurActivite(1L,"123","test");

        when(secteurRepo.findById(1L)).thenReturn(Optional.of(s));
        SecteurActivite secteur= secteurService.retrieveSecteurActivite(1L);
        Assertions.assertNotNull(secteur);
        log.info("get ==>"+ secteur.toString());

    }
    @Test
    public void addSecteurActiviteTest(){
        SecteurActivite s = new SecteurActivite(1L,"123","test");
        s.setIdSecteurActivite(2L);
        secteurService.addSecteurActivite(s);
        verify(secteurRepo, times(1)).save(s);
        System.out.println(s);
        log.info("add ==>"+ s.toString());


    }

    @Test
    public void retrieveAllFournisseursTest()
    {
        List<SecteurActivite> Ls = new ArrayList<SecteurActivite>() {

            {
                add(new SecteurActivite(1L,"123","test"));
                add(new SecteurActivite(1L,"123","test"));
                add(new SecteurActivite(1L,"123","test"));
            }};


        when(secteurService.retrieveAllSecteurActivite()).thenReturn(Ls);
        //test
        List<SecteurActivite> secteurList = secteurService.retrieveAllSecteurActivite();
        assertEquals(3, secteurList.size());
        log.info("retrieve all ==>"+ secteurList.toString());


    }

    @Test
    public void deleteSecteurActiviteTest() {
        SecteurActivite s = new SecteurActivite(6L,"123","test");

        secteurRepo.save(s);
        secteurService.deleteSecteurActivite(s.getIdSecteurActivite());
        verify(secteurRepo, times(1)).deleteById(s.getIdSecteurActivite());
        log.info("delete ==>"+ s.toString());


    }


    @Test
    public void updateSecteurActiviteTest() {
        SecteurActivite s = new SecteurActivite(1L,"123","test");
        when(secteurRepo.save(s)).thenReturn(s);
        assertNotNull(s);
        assertEquals(s, secteurService.addSecteurActivite(s));
        log.info("update ==>"+ s.toString());


    }


}