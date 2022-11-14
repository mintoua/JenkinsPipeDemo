package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Facture;

import java.util.Date;
import java.util.List;

public interface IFactureService {
	List<Facture> retrieveAllFactures();

	List<Facture> getFacturesByFournisseur(Long idFournisseur);

	public Facture addFacture(Facture f);

	public Facture cancelFacture(Facture f);

	Facture retrieveFacture(Long id);
	
	public void assignOperateurToFacture(Long idOperateur, Long idFacture);

	public float pourcentageRecouvrement(Date startDate, Date endDate);

}
