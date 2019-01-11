package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Etablissement implements Serializable{



	@Id
	@GeneratedValue
	private int  idEtablissement;
	
	@NotEmpty
	private String nomEtablissement;

	public int getIdEtablissement() {
		return idEtablissement;
	}

	public void setIdEtablissement(int idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public String getNomEtablissement() {
		return nomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	public Etablissement(int idEtablissement, String nomEtablissement) {
		super();
		this.idEtablissement = idEtablissement;
		this.nomEtablissement = nomEtablissement;
	}

	public Etablissement() {
		super();
	}
	
	
}
