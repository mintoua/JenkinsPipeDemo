package tn.esprit.rh.achat.dto;

import java.util.Date;


import lombok.Data;

@Data
public class DtoFacture {
	private float montantRemise;
	private float montantFacture;
	private Boolean archivee;
	private Date dateCreationFacture;
	private Date dateDerniereModificationFacture;
}
