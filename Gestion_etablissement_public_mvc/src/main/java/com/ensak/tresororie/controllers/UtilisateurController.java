package com.ensak.tresororie.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensak.tresororie.entites.Utilisateur;
import com.ensak.tresororie.services.IUtilisateurService;
import com.ensak.tresororie.services.impl.UtilisateurServiceImpl;

@Controller
@RequestMapping(value="/utilisateur")
public class UtilisateurController {



	@Autowired
	private IUtilisateurService utilisateurService;
	
	
	
	
	@RequestMapping(value="/")
	public String utilisateur(Model model) {
		
		List<Utilisateur> utilisateurs = utilisateurService.selectAll();
		if(utilisateurs==null) {
			utilisateurs=new ArrayList<Utilisateur>();
		}
		model.addAttribute("utilisateurs", utilisateurs);
		return "utilisateur/utilisateurs";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterutilisateur(Model model) {
		Utilisateur utilisateur=new Utilisateur();
		model.addAttribute("utilisateur", utilisateur);
		
		
		return "utilisateur/ajouterUtilisateur";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerutilisateur(Model model,@Valid Utilisateur utilisateur,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			return "utilisateur/ajouterUtilisateur";
		}
		try {
	     if(utilisateur != null) {
	    	 
	    	 Utilisateur et=utilisateurService.getById(utilisateur.getIdUtilisateur());
	    	 if(et==null) {
	    		 utilisateur.setMotDePasse(Integer.toString(utilisateur.getIdUtilisateur()));
	    		 utilisateurService.save(utilisateur);
	    		 
	    	 }else {
	    		 throw new Exception("Ce utilisateur existe déjà");
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "utilisateur/ajouterUtilisateur";
		}
		return "redirect:/utilisateur/";
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idutilisateur}")
	public String modifierutilisateur(Model model, @PathVariable int idutilisateur) {
		
			
			Utilisateur utilisateur = utilisateurService.getById(idutilisateur);
		
			if (utilisateur != null) {
				model.addAttribute("utilisateur", utilisateur);
			}
		
		return "utilisateur/modifierUtilisateur";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,Utilisateur utilisateur) {
		     if(utilisateur != null) {
		    	 utilisateurService.update(utilisateur);
		     }
			return "redirect:/utilisateur/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idutilisateur}")
	public String supprimerutilisateur(Model model, @PathVariable int idutilisateur) {
		if (new Integer(idutilisateur)!= null) {
			Utilisateur f =utilisateurService.getById(idutilisateur);
			if (f != null) {
				//TODO Verification avant suppression
				utilisateurService.remove(idutilisateur);
			}
		}
		return "redirect:/utilisateur/";
	}

}
