
package tn.esprit.rh.achat.services;


        import lombok.extern.slf4j.Slf4j;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.junit.jupiter.MockitoExtension;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;
        import tn.esprit.rh.achat.entities.Operateur;
        import tn.esprit.rh.achat.repositories.OperateurRepository;


        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.times;
        import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
 class OperateurTest {
    @Mock
    OperateurRepository operateurRepository;
    @InjectMocks
    OperateurServiceImpl operateurService;
    Operateur operateur = new Operateur("nom","prenom","password");
    List<Operateur> operateurs = new ArrayList<Operateur>(){
        {
            add(operateur);
            add(operateur);
        }
    };
    @Test
     void addOperateur() {
        Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(operateur);
        Operateur operateur1 = operateurService.addOperateur(operateur);
        assertAll("adOperateur",
                () -> assertEquals(operateur1.getNom(), operateur.getNom()),
                () -> assertEquals(operateur1.getPrenom(), operateur.getPrenom()),
                () -> assertEquals(operateur1.getPassword(), operateur.getPassword())
        );
        verify(operateurRepository, times(1)).save(Mockito.any(Operateur.class));
    }
    void retriveAllOperateur() {
        Mockito.when(operateurRepository.findAll()).thenReturn(operateurs);
        List<Operateur> operateurs1 = operateurService.retrieveAllOperateurs();
        assertEquals(operateurs1.size(), operateurs.size());
        verify(operateurRepository, times(1)).findAll();
    }
    @Test
    void updateOperateur() {
        operateur.setNom("updated");
        Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(operateur);
        Operateur operateur1 = operateurService.addOperateur(operateur);
        assertEquals("updated",operateur1.getNom() );
        verify(operateurRepository, times(1)).save(Mockito.any(Operateur.class));
    }
    @Test
    void retriveOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        Operateur operateur1 = operateurService.retrieveOperateur(1L);
        assertAll("retriveOperateur",
                () -> assertEquals(operateur1.getNom(), operateur.getNom()),
                () -> assertEquals(operateur1.getPrenom(), operateur.getPrenom()),
                () -> assertEquals(operateur1.getPassword(), operateur.getPassword())
        );
        verify(operateurRepository, times(1)).findById(Mockito.anyLong());
    }
}