package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.IBeneficaireDao;
import com.ensak.tresororie.entites.Beneficaire;
import com.ensak.tresororie.services.IBeneficaireService;

@Transactional
public class BeneficaireServiceImpl  implements IBeneficaireService{

	private IBeneficaireDao dao;
	
	
	public void setDao(IBeneficaireDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Beneficaire save(Beneficaire entity) {
		
		return dao.save(entity);
	}

	@Override
	public Beneficaire update(Beneficaire entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Beneficaire> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Beneficaire> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public Beneficaire getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public Beneficaire findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Beneficaire findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	

}
