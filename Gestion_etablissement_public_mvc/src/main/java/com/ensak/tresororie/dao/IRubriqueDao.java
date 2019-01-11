package com.ensak.tresororie.dao;

import java.util.List;

import com.ensak.tresororie.entites.Rubrique;

public interface IRubriqueDao extends IGenericDao<Rubrique>{

	public List<Rubrique> getRubriquesDepense();
	public List<Rubrique> getRubriquesRecette();
}
