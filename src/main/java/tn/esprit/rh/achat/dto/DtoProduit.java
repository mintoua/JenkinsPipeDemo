package tn.esprit.rh.achat.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DtoProduit {
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	private Date dateCreation;
	private Date dateDerniereModification;
}
