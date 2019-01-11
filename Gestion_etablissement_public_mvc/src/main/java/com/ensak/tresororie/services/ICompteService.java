package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.Compte;

public interface ICompteService {

	public Compte save(Compte entity);
	
	public Compte update(Compte entity);
	
	public List<Compte> selectAll();
	
	public List<Compte> selectAll(String sortField, String sort);
	
	public Compte getById(int id);
	
	public void remove(int id);
	
	public Compte findOne(String paramName, Object paramValue);
	
	public Compte findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
