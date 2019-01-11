package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.Etablissement;

public interface IEtablissementService {

public Etablissement save(Etablissement entity);
	
	public Etablissement update(Etablissement entity);
	
	public List<Etablissement> selectAll();
	
	public List<Etablissement> selectAll(String sortField, String sort);
	
	public Etablissement getById(int id);
	
	public void remove(int id);
	
	public Etablissement findOne(String paramName, Object paramValue);
	
	public Etablissement findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
