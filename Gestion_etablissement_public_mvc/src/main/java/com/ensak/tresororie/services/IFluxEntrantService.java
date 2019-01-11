package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.FluxEntrant;

public interface IFluxEntrantService {

	public FluxEntrant save(FluxEntrant entity);
	
	public FluxEntrant update(FluxEntrant entity);
	
	public List<FluxEntrant> selectAll();
	
	public List<FluxEntrant> selectAll(String sortField, String sort);
	
	public FluxEntrant getById(int id);
	
	public void remove(int id);
	
	public FluxEntrant findOne(String paramName, Object paramValue);
	
	public FluxEntrant findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
