package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Rubrique implements Serializable{
	
	@Id
	private int idRubrique;
	
	@NotEmpty
	private String libelle;
	
	@NotEmpty
	private String type;
	
	@NotEmpty
	private String typeBudget;

	public String getTypeBudget() {
		return typeBudget;
	}

	public void setTypeBudget(String typeBudget) {
		this.typeBudget = typeBudget;
	}

	public int getIdRubrique() {
		return idRubrique;
	}

	public void setIdRubrique(int idRubrique) {
		this.idRubrique = idRubrique;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
