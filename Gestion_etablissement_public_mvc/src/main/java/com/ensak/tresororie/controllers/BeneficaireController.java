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

import com.ensak.tresororie.entites.Beneficaire;
import com.ensak.tresororie.services.IBeneficaireService;
import com.ensak.tresororie.services.impl.BeneficaireServiceImpl;


@Controller
@RequestMapping(value="/beneficaire")
public class BeneficaireController {


	@Autowired
	private IBeneficaireService beneficaireService;
	
	
	
	
	@RequestMapping(value="/")
	public String Beneficaire(Model model) {
		System.out.println("this is controller");
		List<Beneficaire> beneficaires = beneficaireService.selectAll();
		if(beneficaires==null) {
			beneficaires=new ArrayList<Beneficaire>();
		}
		model.addAttribute("beneficaires", beneficaires);
		return "Beneficaire/Beneficaires";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterBeneficaire(Model model) {
		Beneficaire beneficaire=new Beneficaire();
		model.addAttribute("beneficaire", beneficaire);
		
		
		return "Beneficaire/ajouterBeneficaire";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerBeneficaire(Model model,@Valid Beneficaire beneficaire,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			return "Beneficaire/ajouterBeneficaire";
		}
		try {
	     if(beneficaire != null) {
	    	 
	    	 Beneficaire et=beneficaireService.getById(beneficaire.getIdBeneficaire());
	    	 if(et==null) {
	    		 beneficaireService.save(beneficaire);
	    		 
	    	 }else {
	    		 throw new Exception("Ce Beneficaire existe déjà");
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "Beneficaire/ajouterBeneficaire";
		}
		return "redirect:/beneficaire/";
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idBeneficaire}")
	public String modifierBeneficaire(Model model, @PathVariable int idBeneficaire) {
		
			
			Beneficaire beneficaire = beneficaireService.getById(idBeneficaire);
		
			if (beneficaire != null) {
				model.addAttribute("beneficaire", beneficaire);
			}
		
		return "Beneficaire/modifierBeneficaire";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,Beneficaire beneficaire) {
		     if(beneficaire != null) {
		    	 beneficaireService.update(beneficaire);
		     }
			return "redirect:/beneficaire/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idBeneficaire}")
	public String supprimerBeneficaire(Model model, @PathVariable int idBeneficaire) {
		if (new Integer(idBeneficaire)!= null) {
			Beneficaire f =beneficaireService.getById(idBeneficaire);
			if (f != null) {
				//TODO Verification avant suppression
				beneficaireService.remove(idBeneficaire);
			}
		}
		return "redirect:/beneficaire/";
	}

}
