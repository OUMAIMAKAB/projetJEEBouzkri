package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CreditOuvert implements Serializable{
    
	 @Id
	 @GeneratedValue
	private int idCreditOuvert;

	private double somme;

	private double sommeConsomme;
	/////////////////////////////////////////////////////////////////////////////////

	    @ManyToOne
	 	@JoinColumn(name="idCompte")
		private Compte compte;
	    
	     @ManyToOne
	 	@JoinColumn(name="annee")
		private Exercice exercice;
	     
	     @ManyToOne
	 	@JoinColumn(name="idRubrique")
		private Rubrique rubrique;
	     
	    

		public double getSommeConsomme() {
			return sommeConsomme;
		}

		public void setSommeConsomme(double sommeConsomme) {
			this.sommeConsomme = sommeConsomme;
		}

		public int getIdCreditOuvert() {
			return idCreditOuvert;
		}

		public void setIdCreditOuvert(int idCreditOuvert) {
			this.idCreditOuvert = idCreditOuvert;
		}

		public double getSomme() {
			return somme;
		}

		public void setSomme(double somme) {
			this.somme = somme;
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

		public void setExercice(Exercice exercice) {
			this.exercice = exercice;
		}

		public Rubrique getRubrique() {
			return rubrique;
		}

		public void setRubrique(Rubrique rubrique) {
			this.rubrique = rubrique;
		}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	     
	     
}
