package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.OrdrePaiement;

public interface IOrdrePaiementService {

public OrdrePaiement save(OrdrePaiement entity);
	
	public OrdrePaiement update(OrdrePaiement entity);
	
	public List<OrdrePaiement> selectAll();
	
	public List<OrdrePaiement> selectAll(String sortField, String sort);
	
	public OrdrePaiement getById(int id);
	
	public void remove(int id);
	
	public OrdrePaiement findOne(String paramName, Object paramValue);
	
	public OrdrePaiement findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
