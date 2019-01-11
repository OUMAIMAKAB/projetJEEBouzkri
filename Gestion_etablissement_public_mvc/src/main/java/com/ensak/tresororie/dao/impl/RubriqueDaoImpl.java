package com.ensak.tresororie.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ensak.tresororie.dao.IRubriqueDao;
import com.ensak.tresororie.entites.Rubrique;

public class RubriqueDaoImpl extends GenericDaoImpl<Rubrique> implements IRubriqueDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Rubrique> getRubriquesDepense() {
		Query query = em.createQuery("select t from Rubrique t where type= :x");
		query.setParameter("x", "Depense");
		return query.getResultList();
	}

	@Override
	public List<Rubrique> getRubriquesRecette() {
		Query query = em.createQuery("select t from Rubrique t where type= :x");
		query.setParameter("x", "Recette");
		return query.getResultList();
	}

}
