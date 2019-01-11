package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.ICompteDao;
import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.services.ICompteService;

@Transactional
public class CompteServiceImpl implements ICompteService{

private ICompteDao dao;
	
	
	public void setDao(ICompteDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Compte save(Compte entity) {
		
		return dao.save(entity);
	}

	@Override
	public Compte update(Compte entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Compte> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Compte> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public Compte getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public Compte findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Compte findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	
}
