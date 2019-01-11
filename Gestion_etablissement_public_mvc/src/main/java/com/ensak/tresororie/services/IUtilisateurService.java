package com.ensak.tresororie.services;

import java.util.List;

import com.ensak.tresororie.entites.Utilisateur;



public interface IUtilisateurService {

   public Utilisateur save(Utilisateur entity);
	
	public Utilisateur update(Utilisateur entity);
	
	public List<Utilisateur> selectAll();
	
	public List<Utilisateur> selectAll(String sortField, String sort);
	
	public Utilisateur getById(int id);
	
	public void remove(int id);
	
	public Utilisateur findOne(String paramName, Object paramValue);
	
	public Utilisateur findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
