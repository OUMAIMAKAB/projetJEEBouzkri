package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.IEtablissementDao;
import com.ensak.tresororie.entites.Etablissement;
import com.ensak.tresororie.services.IEtablissementService;

@Transactional
public class EtablissementServiceImpl implements IEtablissementService{

private IEtablissementDao dao;
	
	
	public void setDao(IEtablissementDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Etablissement save(Etablissement entity) {
		
		return dao.save(entity);
	}

	@Override
	public Etablissement update(Etablissement entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Etablissement> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Etablissement> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public Etablissement getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public Etablissement findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Etablissement findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	
}
