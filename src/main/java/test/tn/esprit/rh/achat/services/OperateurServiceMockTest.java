package test.tn.esprit.rh.achat.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OperateurServiceMockTest {
    @Mock
    OperateurRepository operateurRepository;
    @InjectMocks
    OperateurServiceImpl operateurService;

    Operateur operateur1 = new Operateur(1L,"jecer","ben hammouda","test");
    Operateur operateur2 = new Operateur(2L,"mehdi","ben hammouda","test");
    Operateur operateur3 = new Operateur(3L,"yasmin","ben hammouda","test");

    List<Operateur> listOperateur = new ArrayList<Operateur>(){
        {
            add(operateur1);
            add(operateur2);
            add(operateur3);
        }
    };


    @Test
    public void testRetrieveOperateur(){
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur1));
        Operateur o1 = operateurService.retrieveOperateur(1L);
        assertNotNull(o1);
        Assertions.assertEquals(o1.getIdOperateur(),1L);
        System.out.println("test retrieve passed");
    }

    @Test
    public void testretrieveAllOprateur() {
        Mockito.when(operateurRepository.findAll()).thenReturn(listOperateur);
        List<Operateur> listOpRes = operateurService.retrieveAllOperateurs();
        assertEquals(3, listOpRes.size());
        System.out.println("test retrieve all passed");
    }
}
