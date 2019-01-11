package com.ensak.tresororie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensak.tresororie.entites.Beneficaire;
import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.Etablissement;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.Rubrique;
import com.ensak.tresororie.entites.Utilisateur;
import com.ensak.tresororie.services.IBeneficaireService;
import com.ensak.tresororie.services.ICompteService;
import com.ensak.tresororie.services.IEtablissementService;
import com.ensak.tresororie.services.IExerciceService;
import com.ensak.tresororie.services.IRubriqueService;
import com.ensak.tresororie.services.IUtilisateurService;



@Controller
@RequestMapping(value="/accueil")
public class accueilController {
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@Autowired
	IEtablissementService etablissementService;
	
	@Autowired 
	ICompteService compteService;
	
	@Autowired
	IRubriqueService rubriqueService;
	
	@Autowired
	IBeneficaireService beneficaireService;
	
	@Autowired
	IExerciceService exericeService;

	
	@RequestMapping(value="/")
	public String home(Model model) {
		
		int nombre_utilisateurs=0;
		int nombre_etablissement=0;
		int nombre_compte=0;
		int nombre_rubriques=0;
		int nombre_beneficaires=0;
		int nombre_exercices=0;
		try {
			List<Utilisateur> utilisateurs=utilisateurService.selectAll();	
			nombre_utilisateurs=utilisateurs.size();
		}catch (Exception e) {
			
		}
		model.addAttribute("nombre_utilisateurs",new Integer(nombre_utilisateurs));
		
		try {
			List<Etablissement> etablissements=etablissementService.selectAll();	
			nombre_etablissement=etablissements.size();
		}catch (Exception e) {
			
		}
		model.addAttribute("nombre_etablissements",new Integer(nombre_etablissement));
		
		try {
			List<Compte> comptes=compteService.selectAll();	
			nombre_compte=comptes.size();
		}catch (Exception e) {
			
		}
		model.addAttribute("nombre_comptes",new Integer(nombre_compte));
		
		try {
			List<Rubrique> rubriques=rubriqueService.selectAll();	
			nombre_rubriques=rubriques.size();
		}catch (Exception e) {
			
		}
		model.addAttribute("nombre_rubriques",new Integer(nombre_rubriques));
		
		try {
			List<Beneficaire> beneficaires=beneficaireService.selectAll();	
			nombre_beneficaires=beneficaires.size();
		}catch (Exception e) {
			
		}
		model.addAttribute("nombre_beneficaires",new Integer(nombre_beneficaires));
		
		try {
			List<Exercice> exercices=exericeService.selectAll();	
			nombre_exercices=exercices.size();
		}catch (Exception e) {
			
		}
		model.addAttribute("nombre_exercices",new Integer(nombre_exercices));
		
		return "accueil/accueil";
	}

}
