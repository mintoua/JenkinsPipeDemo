package tn.esprit.rh.achat.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DtoReglement {
	private float montantPaye;
	private float montantRestant;
	private Boolean payee;
	private Date dateReglement;
}
