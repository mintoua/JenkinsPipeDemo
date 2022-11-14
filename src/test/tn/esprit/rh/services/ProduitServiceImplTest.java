package tn.esprit.rh.services;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.entities.Produit;
import tn.esprit.rh.repositories.ProduitRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduitServiceImplTest {
	 @Autowired
    IProduitService produitService;

    @Autowired
    ProduitRepository produitRepository;

    Produit p1 = new Produit(55L, "2365","produit1",50);
    Produit p2 = new Produit(66L, "5681","produit5",120);
    @Test
    @Order(1)
    public void testaddProdiut() {
        Produit produitAdded =  produitService.addProduit(p1);
        Assertions.assertEquals(produitAdded.getCodeProduit(), produitAdded.getCodeProduit());
    }

    @Test
    @Order(2)
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(listProduits.size(), listProduits.size());
    }

  
	
	
	
}
