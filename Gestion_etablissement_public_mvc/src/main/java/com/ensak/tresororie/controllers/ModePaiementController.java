package com.ensak.tresororie.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensak.tresororie.entites.Compte;
import com.ensak.tresororie.entites.ModePaiement;
import com.ensak.tresororie.entites.Beneficaire;
import com.ensak.tresororie.services.ICompteService;
import com.ensak.tresororie.services.IModePaiementService;
import com.ensak.tresororie.services.IBeneficaireService;

@Controller
@RequestMapping(value="/modePaiement")
public class ModePaiementController {
	
	@Autowired
	private IModePaiementService modePaiemebtService;
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired
	private IBeneficaireService beneficaireService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	
	@RequestMapping(value="/")
	public String ModePaiement(Model model) {
		
		List<ModePaiement> modePaiements = modePaiemebtService.selectAll();
		if(modePaiements==null) {
			modePaiements=new ArrayList<ModePaiement>();
		}
		model.addAttribute("modePaiements", modePaiements);
		return "ModePaiement/ModePaiements";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterModePaiement(Model model) {
		
	ModePaiement modePaiement=new ModePaiement();
	model.addAttribute("modePaiement", modePaiement);
	
	String [] typesMode= {"cheque","virement"};
	model.addAttribute("typesMode",typesMode);
	
    List <Beneficaire> beneficaires= beneficaireService.selectAll();
	if(beneficaires == null) {
		beneficaires= new ArrayList<Beneficaire> ();
	}
	model.addAttribute("beneficaires", beneficaires);
	
	List <Compte> comptes= compteService.selectAll();
	if(comptes == null) {
		comptes= new ArrayList<Compte> ();
	}
	model.addAttribute("comptes", comptes);
	
		return "ModePaiement/ajouterModePaiement";
		
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerModePaiement(Model model,@Valid ModePaiement modePaiement,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
		
			List <Compte> comptes= compteService.selectAll();
			if(comptes == null) {
				comptes= new ArrayList<Compte> ();
			}
			model.addAttribute("comptes", comptes);
			
			
			
			
			String [] typesMode= {"cheque","virement"};
			model.addAttribute("typesMode",typesMode);
			
			
			List <Beneficaire> beneficaires= beneficaireService.selectAll();
			if(beneficaires == null) {
				beneficaires= new ArrayList<Beneficaire> ();
			}
			model.addAttribute("beneficaires", beneficaires);
			return "ModePaiement/ajouterModePaiement";
		}
		try {
	     if(modePaiement != null) {
	    	 
	  	 ModePaiement et=modePaiemebtService.getById(modePaiement.getIdModePaiement());
	    	 if(et==null) {
	    		 
	    	//	 Compte compte=compteService.getById(modePaiement.getCompte().getIdCompte());
	    		 //compte.addBudgetFonctionnel(modePaiement.getBudgetFonctionnel());
	    		 //compte.addBudgetInvestissement(modePaiement.getBudgetInvestissement());
	    		// compteService.update(compte);
	    	Date date1= modePaiement.getDateEmission();
	    	System.out.println("Date1" +date1);
	    		 modePaiemebtService.save(modePaiement);
	    		 
	    	 }else {
	    		 throw new Exception("Cet ModePaiement existe déjà");
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "ModePaiement/ajouterModePaiement";
		}
		return "redirect:/modePaiement/";
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idModePaiement}")
	public String modifierModePaiement(Model model, @PathVariable int idModePaiement) {
		
			
			ModePaiement modePaiement = modePaiemebtService.getById(idModePaiement);
			
			String [] typesMode= {"cheque","virement"};
			model.addAttribute("typesMode",typesMode);
			
			List <Compte> comptes= compteService.selectAll();
			if(comptes == null) {
				comptes= new ArrayList<Compte> ();
			}
			model.addAttribute("comptes", comptes);
			
			
			List <Beneficaire> beneficaires= beneficaireService.selectAll();
			if(beneficaires == null) {
				beneficaires= new ArrayList<Beneficaire> ();
			}
			model.addAttribute("beneficaires", beneficaires);
			
			String [] types= {"Fonctionnel","Investissement"};
			model.addAttribute("types",types);
			
			
			if (modePaiement != null) {
				model.addAttribute("modePaiement", modePaiement);
				
			}
		
		return "ModePaiement/modifierModePaiement";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,ModePaiement modePaiement) {
		     if(modePaiement != null) {
		    	 modePaiemebtService.update(modePaiement);
		     }
			return "redirect:/modePaiement/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idModePaiement}")
	public String supprimerModePaiement(Model model, @PathVariable int idModePaiement) {
		if (new Integer(idModePaiement)!= null) {
			ModePaiement f =modePaiemebtService.getById(idModePaiement);
			if (f != null) {
				//TODO Verification avant suppression
				modePaiemebtService.remove(idModePaiement);
			}
		}
		return "redirect:/modePaiement/";
	}



}
