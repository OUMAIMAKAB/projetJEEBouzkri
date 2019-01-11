package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.ModePaiement;

public interface IModePaiementService {

public ModePaiement save(ModePaiement entity);
	
	public ModePaiement update(ModePaiement entity);
	
	public List<ModePaiement> selectAll();
	
	public List<ModePaiement> selectAll(String sortField, String sort);
	
	public ModePaiement getById(int id);
	
	public void remove(int id);
	
	public ModePaiement findOne(String paramName, Object paramValue);
	
	public ModePaiement findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
