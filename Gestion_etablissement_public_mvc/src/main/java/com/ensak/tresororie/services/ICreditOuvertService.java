package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.CreditOuvert;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.Rubrique;

public interface ICreditOuvertService {

public CreditOuvert save(CreditOuvert entity);
	
	public CreditOuvert update(CreditOuvert entity);
	
	public List<CreditOuvert> selectAll();
	
	public List<CreditOuvert> selectAll(String sortField, String sort);
	
	public CreditOuvert getById(int id);
	
	public void remove(int id);
	
	public CreditOuvert findOne(String paramName, Object paramValue);
	
	public CreditOuvert findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	public boolean isExistCreditOuvert(Exercice exercice, Compte compte, Rubrique rubrique);
	
	public CreditOuvert getCreditOuvertDeLaRubrique(Rubrique rubrique);
}
