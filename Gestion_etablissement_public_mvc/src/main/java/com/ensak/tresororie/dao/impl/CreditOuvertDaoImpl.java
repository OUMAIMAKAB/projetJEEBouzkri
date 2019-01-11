package com.ensak.tresororie.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ensak.tresororie.dao.ICreditOuvertDao;
import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.CreditOuvert;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.Rubrique;

public class CreditOuvertDaoImpl extends GenericDaoImpl<CreditOuvert> implements ICreditOuvertDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean isExistCreditOuvert(Exercice exercice, Compte compte, Rubrique rubrique){
		Query query = em.createQuery("select t from CreditOuvert t where t.compte= :y and t.exercice= :x and t.rubrique= :z");

		query.setParameter("y", compte);
		query.setParameter("x", exercice);
		query.setParameter("z", rubrique);
		
		if(query.getResultList().isEmpty())
			return false;
		else
			return true;
	
				
	}

	@Override
	public CreditOuvert getCreditOuvertDeLaRubrique(Rubrique rubrique) {
		Query query = em.createQuery("select t from CreditOuvert t where t.rubrique= :x ");
		query.setParameter("x", rubrique);
		return (CreditOuvert) query.getResultList().get(0);
	}

	
}
