package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.ICreditOuvertDao;
import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.CreditOuvert;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.Rubrique;
import com.ensak.tresororie.services.ICreditOuvertService;

@Transactional
public class CreditOuvertServiceImpl implements ICreditOuvertService{

private ICreditOuvertDao dao;
	
	
	public void setDao(ICreditOuvertDao dao) {
		this.dao = dao;
	}
	
	@Override
	public CreditOuvert save(CreditOuvert entity) {
		
		return dao.save(entity);
	}

	@Override
	public CreditOuvert update(CreditOuvert entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<CreditOuvert> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<CreditOuvert> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public CreditOuvert getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public CreditOuvert findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CreditOuvert findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public boolean isExistCreditOuvert(Exercice exercice, Compte compte, Rubrique rubrique) {
		
		return dao.isExistCreditOuvert(exercice, compte, rubrique);
	}

	@Override
	public CreditOuvert getCreditOuvertDeLaRubrique(Rubrique rubrique) {
		
		return dao.getCreditOuvertDeLaRubrique(rubrique);
	}

	
}
