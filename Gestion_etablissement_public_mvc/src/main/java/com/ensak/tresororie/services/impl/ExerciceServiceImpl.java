package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.IExerciceDao;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.services.IExerciceService;
@Transactional
public class ExerciceServiceImpl implements IExerciceService{
private IExerciceDao dao;
	
	
	public void setDao(IExerciceDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Exercice save(Exercice entity) {
		
		return dao.save(entity);
	}

	@Override
	public Exercice update(Exercice entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Exercice> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Exercice> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public Exercice getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public Exercice findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Exercice findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}


}
