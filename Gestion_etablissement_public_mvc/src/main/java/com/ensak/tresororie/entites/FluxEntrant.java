package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FluxEntrant implements Serializable{
	 
	 @Id
	 @GeneratedValue
     private int idFluxEntrant;
	 
	 private double somme;
	 
	/////////////////////////////////////
     
  
	@ManyToOne
 	@JoinColumn(name="idCompte")
	private Compte compte;
    
     @ManyToOne
 	@JoinColumn(name="annee")
	private Exercice exercice;
     
     @ManyToOne
 	@JoinColumn(name="idRubrique")
	private Rubrique rubrique;

	public int getIdFluxEntrant() {
		return idFluxEntrant;
	}

	public void setIdFluxEntrant(int idFluxEntrant) {
		this.idFluxEntrant = idFluxEntrant;
	}

	
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setIdExercice(Exercice exercice) {
		this.exercice =exercice;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}
	
	   public double getSomme() {
			return somme;
		}

		public void setSomme(double somme) {
			this.somme = somme;
		}


     //////////////////////////////////
     
     
     
}
