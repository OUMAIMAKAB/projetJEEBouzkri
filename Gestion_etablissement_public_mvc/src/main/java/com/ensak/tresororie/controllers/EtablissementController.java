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

import com.ensak.tresororie.services.IEtablissementService;
import com.ensak.tresororie.entites.Etablissement;

@Controller
@RequestMapping(value="/etablissement")
public class EtablissementController {

	 
		@Autowired
		private IEtablissementService etablissementService;
		
		
		@RequestMapping(value="/")
		public String Etablissement(Model model) {
			
			List<Etablissement> etablissements = etablissementService.selectAll();
			if(etablissements==null) {
				etablissements=new ArrayList<Etablissement>();
			}
			model.addAttribute("etablissements", etablissements);
			return "Etablissement/Etablissements";
		}
		
		
		
		
		@RequestMapping(value="/nouveau",method=RequestMethod.GET)
		public String ajouterEtablissement(Model model) {
			Etablissement etablissement=new Etablissement();
			model.addAttribute("etablissement", etablissement);
			return "Etablissement/ajouterEtablissement";
		}
		
		
		@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
		public String enregistrerEtablissement(Model model,@Valid Etablissement etablissement,BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "Etablissement/ajouterEtablissement";
			}
			try {
		     if(etablissement != null) {
		    	 
		    	 Etablissement et=etablissementService.findOne("nomEtablissement", etablissement.getNomEtablissement());
		    	 if(et==null) {
		    		 etablissementService.save(etablissement);
		    		 
		    	 }else {
		    		 throw new Exception("Cet Etablissement existe déjà");
		    	 }
		    	 
		     }
		     }
		     catch (Exception e) {
		    	 model.addAttribute("exception", e.getMessage());
				return "Etablissement/ajouterEtablissement";
			}
			return "redirect:/etablissement/";
		}
		
		
		
		
		@RequestMapping(value = "/modifier/{idEtablissement}")
		public String modifierEtablissement(Model model, @PathVariable int idEtablissement) {
			
				
				Etablissement etablissement = etablissementService.getById(idEtablissement);
				if (etablissement != null) {
					model.addAttribute("etablissement", etablissement);
				}
			
			return "Etablissement/modifierEtablissement";
		}
		
		
		
		@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
	   public String enregistrerModification(Model model,Etablissement etablissement) {
			     if(etablissement != null) {
			    	 etablissementService.update(etablissement);
			     }
				return "redirect:/etablissement/";
		}
		
		
		
		@RequestMapping(value = "/supprimer/{idEtablissement}")
		public String supprimerEtablissement(Model model, @PathVariable int idEtablissement) {
			if (new Integer(idEtablissement)!= null) {
				Etablissement f =etablissementService.getById(idEtablissement);
				if (f != null) {
					//TODO Verification avant suppression
					etablissementService.remove(idEtablissement);
				}
			}
			return "redirect:/etablissement/";
		}
	
		
		
		
}
