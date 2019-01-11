package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdrePaiement implements Serializable{

	@Id
	@GeneratedValue
	private int idOrdrePaiement;
	
	/////////////////////////////////////
	
	@ManyToOne
	@JoinColumn(name="idRubrique")
	private Rubrique rubrique;
	
	@ManyToOne
	@JoinColumn(name="idModePaiement")
	private ModePaiement modePaiement;
		
	@ManyToOne
	@JoinColumn(name="idExercice")
	private Exercice exercice;
		
	 
	public int getIdOrdrePaiement() {
		return idOrdrePaiement;
	}

	public void setIdOrdrePaiement(int idOrdrePaiement) {
		this.idOrdrePaiement = idOrdrePaiement;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}
	
	
	//////////////////////////////////////
	
	
	
	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	
	
}
