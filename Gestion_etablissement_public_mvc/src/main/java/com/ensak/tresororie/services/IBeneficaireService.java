package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.Beneficaire;



public interface IBeneficaireService {

	    public Beneficaire save(Beneficaire entity);
		
		public Beneficaire update(Beneficaire entity);
		
		public List<Beneficaire> selectAll();
		
		public List<Beneficaire> selectAll(String sortField, String sort);
		
		public Beneficaire getById(int id);
		
		public void remove(int id);
		
		public Beneficaire findOne(String paramName, Object paramValue);
		
		public Beneficaire findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
}
