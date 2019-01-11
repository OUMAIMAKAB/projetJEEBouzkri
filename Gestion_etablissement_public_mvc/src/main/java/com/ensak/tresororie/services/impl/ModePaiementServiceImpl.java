package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.IModePaiementDao;
import com.ensak.tresororie.entites.ModePaiement;
import com.ensak.tresororie.services.IModePaiementService;

@Transactional
public class ModePaiementServiceImpl implements IModePaiementService{

private IModePaiementDao dao;
	
	
	public void setDao(IModePaiementDao dao) {
		this.dao = dao;
	}
	
	@Override
	public ModePaiement save(ModePaiement entity) {
		
		return dao.save(entity);
	}

	@Override
	public ModePaiement update(ModePaiement entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<ModePaiement> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<ModePaiement> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public ModePaiement getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public ModePaiement findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public ModePaiement findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

}
