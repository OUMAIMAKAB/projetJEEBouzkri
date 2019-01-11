package com.ensak.tresororie.dao;

import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.CreditOuvert;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.Rubrique;

public interface ICreditOuvertDao  extends IGenericDao<CreditOuvert>{

	public boolean isExistCreditOuvert(Exercice exercice, Compte compte, Rubrique rubrique);
	
	public CreditOuvert getCreditOuvertDeLaRubrique(Rubrique rubrique);
}
