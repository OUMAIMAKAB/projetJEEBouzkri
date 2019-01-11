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
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.CreditOuvert;
import com.ensak.tresororie.entites.Rubrique;
import com.ensak.tresororie.services.ICompteService;
import com.ensak.tresororie.services.IExerciceService;
import com.ensak.tresororie.services.ICreditOuvertService;
import com.ensak.tresororie.services.IRubriqueService;

@Controller
@RequestMapping(value="/creditOuvert")
public class CreditOuvertController {

	@Autowired
	private ICreditOuvertService creditOuvertService;
	
	
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired
	private IExerciceService exerciceService;
	
	@Autowired
	private IRubriqueService rubriqueService;
	
	
	@RequestMapping(value="/")
	public String CreditOuvert(Model model) {
		
		List<CreditOuvert> creditOuverts = creditOuvertService.selectAll();
		if(creditOuverts==null) {
			creditOuverts=new ArrayList<CreditOuvert>();
		}
		model.addAttribute("creditOuverts", creditOuverts);
		return "CreditOuvert/CreditOuverts";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterCreditOuvert(Model model) {
		
	CreditOuvert creditOuvert=new CreditOuvert();
	model.addAttribute("creditOuvert", creditOuvert);
		
		List <Compte> comptes= compteService.selectAll();
		if(comptes == null) {
			comptes= new ArrayList<Compte> ();
		}
		model.addAttribute("comptes", comptes);
		
		List <Exercice> exercices= exerciceService.selectAll();
		if(exercices == null) {
			exercices= new ArrayList<Exercice> ();
		}
		model.addAttribute("exercices", exercices);
		
		List <Rubrique> rubriques= rubriqueService.getRubriquesDepense();
		if(rubriques == null) {
			rubriques= new ArrayList<Rubrique> ();
		}
		model.addAttribute("rubriques", rubriques);
		
		
	
		return "CreditOuvert/ajouterCreditOuvert";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerCreditOuvert(Model model,@Valid CreditOuvert creditOuvert,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List <Compte> comptes= compteService.selectAll();
			if(comptes == null) {
				comptes= new ArrayList<Compte> ();
			}
			model.addAttribute("comptes", comptes);
			
			List <Exercice> exercices= exerciceService.selectAll();
			if(exercices == null) {
				exercices= new ArrayList<Exercice> ();
			}
			model.addAttribute("exercices", exercices);
			
			List <Rubrique> rubriques= rubriqueService.getRubriquesDepense();
			if(rubriques == null) {
				rubriques= new ArrayList<Rubrique> ();
			}
			model.addAttribute("rubriques", rubriques);
			
			
			
			return "CreditOuvert/ajouterCreditOuvert";
		}
		try {
	     if(creditOuvert != null) {
	    	 
	     
	  	 boolean et=creditOuvertService.isExistCreditOuvert(creditOuvert.getExercice(), creditOuvert.getCompte(), creditOuvert.getRubrique());
	    	 //List<CreditOuvert> et=creditOuvertService.selectAll();
	    	// System.out.println("Nombre elemet Tab credit Ouvert "+ et.size());	
	  if(et==false) {
		  /*
	    		 Compte compte=compteService.getById(creditOuvert.getCompte().getIdCompte());
	    		 double sommeExistanteFonctionnel;
	    		 double sommeExistanteInvestissement;
	    		 if(creditOuvert.getRubrique().getTypeBudget().equals("Fonctionnel")) {
	    			 sommeExistanteFonctionnel=compte.getBudgetFonctionnel();
	    			 if(sommeExistanteFonctionnel-creditOuvert.getSomme()<0) {
	    				 throw new Exception("Impossible de tirer cette somme : la somme demandée est supérieur à la somme existante");
	    			 }
	    			 compte.subBudgetFonctionel(creditOuvert.getSomme());
	    		 }else if(creditOuvert.getRubrique().getTypeBudget().equals("Investissement")) {
	    			 sommeExistanteInvestissement=compte.getBudgetInvestissement();
	    			 if(sommeExistanteInvestissement-creditOuvert.getSomme()<0) {
	    				 throw new Exception("Impossible de tirer cette somme : la somme demandée est supérieur à la somme existante");
	    			 }
	    			 compte.subBudgetInvestissement(creditOuvert.getSomme()); 
	    		 }
	    	*/	 
	    		
	    		 creditOuvertService.save(creditOuvert);
	    		 
	    	 }else {
	    		 throw new Exception("Ce CreditOuvert existe déjà avec ce même exercice , compte , rubrique ");
	    		
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
	    	 List <Compte> comptes= compteService.selectAll();
				if(comptes == null) {
					comptes= new ArrayList<Compte> ();
				}
				model.addAttribute("comptes", comptes);
				
				List <Exercice> exercices= exerciceService.selectAll();
				if(exercices == null) {
					exercices= new ArrayList<Exercice> ();
				}
				model.addAttribute("exercices", exercices);
				
				List <Rubrique> rubriques= rubriqueService.getRubriquesDepense();
				if(rubriques == null) {
					rubriques= new ArrayList<Rubrique> ();
				}
				model.addAttribute("rubriques", rubriques);
				
			return "CreditOuvert/ajouterCreditOuvert";
	    	 
		}
		return "redirect:/creditOuvert/";
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idCreditOuvert}")
	public String modifierCreditOuvert(Model model, @PathVariable int idCreditOuvert) {
		
			
			CreditOuvert creditOuvert = creditOuvertService.getById(idCreditOuvert);
			List <Compte> comptes= compteService.selectAll();
			if(comptes == null) {
				comptes= new ArrayList<Compte> ();
			}
			model.addAttribute("comptes", comptes);
			
			List <Exercice> exercices= exerciceService.selectAll();
			if(exercices == null) {
				exercices= new ArrayList<Exercice> ();
			}
			model.addAttribute("exercices", exercices);
			
			List <Rubrique> rubriques= rubriqueService.getRubriquesDepense();
			if(rubriques == null) {
				rubriques= new ArrayList<Rubrique> ();
			}
			model.addAttribute("rubriques", rubriques);
			
		
			
			
			if (creditOuvert != null) {
				model.addAttribute("creditOuvert", creditOuvert);
			}
			
		
		return "CreditOuvert/modifierCreditOuvert";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,CreditOuvert creditOuvert) {
		     if(creditOuvert != null) {
		    	 creditOuvertService.update(creditOuvert);
		     }
			return "redirect:/creditOuvert/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idCreditOuvert}")
	public String supprimerCreditOuvert(Model model, @PathVariable int idCreditOuvert) {
		if (new Integer(idCreditOuvert)!= null) {
			CreditOuvert f =creditOuvertService.getById(idCreditOuvert);
			if (f != null) {
				//TODO Verification avant suppression
				creditOuvertService.remove(idCreditOuvert);
			}
		}
		return "redirect:/creditOuvert/";
	}

}
