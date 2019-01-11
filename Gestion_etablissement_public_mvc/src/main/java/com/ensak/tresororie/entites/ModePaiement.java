package com.ensak.tresororie.entites;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ModePaiement implements Serializable{

	
	@Id
	private int idModePaiement;
	
	
	@NotEmpty
	private String type;
	
	
	private double montant;
	
	
	private Date dateEmission;
	
	
	private Date dateDecaissement;
	
	private Boolean isUsed=false;
	
	//dateEmission
	//dateDecaissement
	
	//////////////////////////////////////
   
	
	
    @ManyToOne
	@JoinColumn(name="idBeneficaire")
	private Beneficaire beneficaire;
    
    public Boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}

	@ManyToOne
	@JoinColumn(name="idCompte")
    private Compte compte;

	/////////////////////////////////////
    
    public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	
	public Date getDateDecaissement() {
		return dateDecaissement;
	}

	public void setDateDecaissement(Date dateDecaissement) {
		this.dateDecaissement = dateDecaissement;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}
	
	
	public int getIdModePaiement() {
		return idModePaiement;
	}

	public void setIdModePaiement(int idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Beneficaire getBeneficaire() {
		return beneficaire;
	}

	public void setBeneficaire(Beneficaire beneficaire) {
		this.beneficaire = beneficaire;
	}
	
	
	
	
	
	
	
}
