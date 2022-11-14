package tn.esprit.achat.dto;

import lombok.Data;
import tn.esprit.rh.achat.entities.CategorieFournisseur;

@Data
public class DtoFournisseur {
	private String code;
	private String libelle;
	private CategorieFournisseur  categorieFournisseur;
}
