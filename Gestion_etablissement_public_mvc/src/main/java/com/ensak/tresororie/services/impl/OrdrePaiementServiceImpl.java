package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.IOrdrePaiementDao;
import com.ensak.tresororie.entites.OrdrePaiement;
import com.ensak.tresororie.services.IOrdrePaiementService;

@Transactional
public class OrdrePaiementServiceImpl implements IOrdrePaiementService{
	
private IOrdrePaiementDao dao;
	
	
	public void setDao(IOrdrePaiementDao dao) {
		this.dao = dao;
	}
	
	@Override
	public OrdrePaiement save(OrdrePaiement entity) {
		
		return dao.save(entity);
	}

	@Override
	public OrdrePaiement update(OrdrePaiement entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<OrdrePaiement> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<OrdrePaiement> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public OrdrePaiement getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public OrdrePaiement findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public OrdrePaiement findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}


}
