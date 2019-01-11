package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Beneficaire implements Serializable{
 
	@Id
	private int idBeneficaire;
	
	@NotEmpty
	private String nom;
	
	@NotEmpty
	private String prenom;

	public int getIdBeneficaire() {
		return idBeneficaire;
	}

	public void setIdBeneficaire(int idBeneficaire) {
		this.idBeneficaire = idBeneficaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
