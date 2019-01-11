package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.Exercice;

public interface IExerciceService {
	
   public Exercice save(Exercice entity);
	
	public Exercice update(Exercice entity);
	
	public List<Exercice> selectAll();
	
	public List<Exercice> selectAll(String sortField, String sort);
	
	public Exercice getById(int id);
	
	public void remove(int id);
	
	public Exercice findOne(String paramName, Object paramValue);
	
	public Exercice findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);

}
