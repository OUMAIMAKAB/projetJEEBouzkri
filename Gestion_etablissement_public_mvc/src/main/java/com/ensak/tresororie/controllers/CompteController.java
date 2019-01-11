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

import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.Etablissement;
import com.ensak.tresororie.services.ICompteService;
import com.ensak.tresororie.services.IEtablissementService;
import com.ensak.tresororie.services.impl.CompteServiceImpl;
import com.ensak.tresororie.services.impl.EtablissementServiceImpl;

@Controller
@RequestMapping(value="/compte")
public class CompteController {

    @Autowired
	private ICompteService compteService;
	
	@Autowired
	private IEtablissementService etablissementService;
	
	
	@RequestMapping(value="/")
	public String Compte(Model model) {
		
		List<Compte> comptes = compteService.selectAll();
		if(comptes==null) {
			comptes=new ArrayList<Compte>();
		}
		model.addAttribute("comptes", comptes);
		return "Compte/Comptes";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterCompte(Model model) {
		Compte compte=new Compte();
		model.addAttribute("compte", compte);
		
		List <Etablissement> etablissements= etablissementService.selectAll();
		if(etablissements == null) {
			etablissements= new ArrayList<Etablissement> ();
		}
		model.addAttribute("etablissements", etablissements);
		return "Compte/ajouterCompte";
	}
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerCompte(Model model,@Valid Compte compte,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			return "Compte/ajouterCompte";
		}
		try {
	     if(compte != null) {
	    	 
	    	 Compte et=compteService.getById(compte.getIdCompte());
	    	 if(et==null) {
	    		 compteService.save(compte);
	    		 
	    	 }else {
	    		 throw new Exception("Ce Compte existe déjà");
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "Compte/ajouterCompte";
		}
		return "redirect:/compte/";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/modifier/{idCompte}")
	public String modifierCompte(Model model, @PathVariable int idCompte) {
		
			
			Compte compte = compteService.getById(idCompte);
			List <Etablissement> etablissements= etablissementService.selectAll();
			if(etablissements == null) {
				etablissements= new ArrayList<Etablissement> ();
			}
			model.addAttribute("etablissements", etablissements);
			if (compte != null) {
				model.addAttribute("compte", compte);
			}
		
		return "Compte/modifierCompte";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,Compte compte) {
		     if(compte != null) {
		    	 compteService.update(compte);
		     }
			return "redirect:/compte/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idCompte}")
	public String supprimerCompte(Model model, @PathVariable int idCompte) {
		if (new Integer(idCompte)!= null) {
			Compte f =compteService.getById(idCompte);
			if (f != null) {
				//TODO Verification avant suppression
				compteService.remove(idCompte);
			}
		}
		return "redirect:/compte/";
	}

}
