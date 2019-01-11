package com.ensak.tresororie.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.tresororie.dao.IFluxEntrantDao;
import com.ensak.tresororie.entites.FluxEntrant;
import com.ensak.tresororie.services.IFluxEntrantService;

@Transactional
public class FluxEntrantServiceImpl implements IFluxEntrantService{

private IFluxEntrantDao dao;
	
	
	public void setDao(IFluxEntrantDao dao) {
		this.dao = dao;
	}
	
	@Override
	public FluxEntrant save(FluxEntrant entity) {
		
		return dao.save(entity);
	}

	@Override
	public FluxEntrant update(FluxEntrant entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<FluxEntrant> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<FluxEntrant> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	@Override
	public FluxEntrant getById(int id) {
		
		return dao.getById(id);
	}

	
	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	
	@Override
	public FluxEntrant findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public FluxEntrant findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

}
