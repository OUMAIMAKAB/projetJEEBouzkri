package com.ensak.tresororie.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Entity
public class Compte implements Serializable{
	
	@Id
	private int idCompte;
	
    @Min(0)
	private double budgetFonctionnel;
	
    @Min(0)
	private double budgetInvestissement;
	
	
	/////////////////////////////
	
    @ManyToOne
	@JoinColumn(name="idEtablissement")
	private Etablissement etablissement;
	////////////////////////////


	public int getIdCompte() {
		return idCompte;
	}


	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}


	public double getBudgetFonctionnel() {
		return budgetFonctionnel;
	}


	public void setBudgetFonctionnel(double budgetFonctionnel) {
		this.budgetFonctionnel = budgetFonctionnel;
	}


	public double getBudgetInvestissement() {
		return budgetInvestissement;
	}


	public void setBudgetInvestissement(double budgetInvestissement) {
		this.budgetInvestissement = budgetInvestissement;
	}


	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement idEtablissement) {
		this.etablissement = idEtablissement;
	}
    
    public void addBudgetFonctionnel(double budgetFonctionnel) {
    	this.budgetFonctionnel+=budgetFonctionnel;
    }
    
    public void addBudgetInvestissement(double budgetInvestissement) {
    	this.budgetInvestissement +=budgetInvestissement;
    }
    
    public void subBudgetFonctionel(double subBudgetFonctionnel) {
    	this.budgetFonctionnel-=subBudgetFonctionnel;
    }
    
    public void subBudgetInvestissement(double subBudgetInvestissement) {
    	this.budgetInvestissement-=subBudgetInvestissement;
    }

}
