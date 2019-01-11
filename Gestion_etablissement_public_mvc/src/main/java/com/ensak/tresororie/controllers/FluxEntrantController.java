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
import com.ensak.tresororie.entites.FluxEntrant;
import com.ensak.tresororie.entites.Rubrique;
import com.ensak.tresororie.services.ICompteService;
import com.ensak.tresororie.services.IExerciceService;
import com.ensak.tresororie.services.IFluxEntrantService;
import com.ensak.tresororie.services.IRubriqueService;

@Controller
@RequestMapping(value="/fluxEntrant")
public class FluxEntrantController {
	
	@Autowired
	private IFluxEntrantService fluxEntrantService;
	
	
	
	@Autowired
	private ICompteService compteService;
	
	@Autowired
	private IExerciceService exerciceService;
	
	@Autowired
	private IRubriqueService rubriqueService;
	
	
	@RequestMapping(value="/")
	public String FluxEntrant(Model model) {
		
		List<FluxEntrant> fluxEntrants = fluxEntrantService.selectAll();
		if(fluxEntrants==null) {
			fluxEntrants=new ArrayList<FluxEntrant>();
		}
		model.addAttribute("fluxEntrants", fluxEntrants);
		return "FluxEntrant/FluxEntrants";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterFluxEntrant(Model model) {
		
	FluxEntrant fluxEntrant=new FluxEntrant();
	model.addAttribute("fluxEntrant", fluxEntrant);
		
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
		
		List <Rubrique> rubriques= rubriqueService.getRubriquesRecette();
		if(rubriques == null) {
			rubriques= new ArrayList<Rubrique> ();
		}
		model.addAttribute("rubriques", rubriques);
	
		return "FluxEntrant/ajouterFluxEntrant";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerFluxEntrant(Model model,@Valid FluxEntrant fluxEntrant,BindingResult bindingResult) {
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
			
			List <Rubrique> rubriques= rubriqueService.getRubriquesRecette();
			if(rubriques == null) {
				rubriques= new ArrayList<Rubrique> ();
			}
			model.addAttribute("rubriques", rubriques);
			return "FluxEntrant/ajouterFluxEntrant";
		}
		try {
	     if(fluxEntrant != null) {
	    	 
	 
	    	
	    		 Compte compte=compteService.getById(fluxEntrant.getCompte().getIdCompte());
	    		 Rubrique rubrique=rubriqueService.getById(fluxEntrant.getRubrique().getIdRubrique());
	    		 String typeBudget=rubrique.getTypeBudget();
	    		 if(typeBudget.equals("Fonctionnel")) {
	    		      compte.addBudgetFonctionnel(fluxEntrant.getSomme());
	    		 }
	    		 if(typeBudget.equals("Investissement")) {
	    		      compte.addBudgetInvestissement(fluxEntrant.getSomme());
	    		 }
	    		 compteService.update(compte);
	    		 fluxEntrantService.save(fluxEntrant);
	    		 
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "FluxEntrant/ajouterFluxEntrant";
		}
		return "redirect:/fluxEntrant/";
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idFluxEntrant}")
	public String modifierFluxEntrant(Model model, @PathVariable int idFluxEntrant) {
		
			
			FluxEntrant fluxEntrant = fluxEntrantService.getById(idFluxEntrant);
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
			
			List <Rubrique> rubriques= rubriqueService.getRubriquesRecette();
			if(rubriques == null) {
				rubriques= new ArrayList<Rubrique> ();
			}
			model.addAttribute("rubriques", rubriques);
			if (fluxEntrant != null) {
				model.addAttribute("fluxEntrant", fluxEntrant);
			}
		
		return "FluxEntrant/modifierFluxEntrant";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,FluxEntrant fluxEntrant) {
		     if(fluxEntrant != null) {
		    	 fluxEntrantService.update(fluxEntrant);
		     }
			return "redirect:/fluxEntrant/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idFluxEntrant}")
	public String supprimerFluxEntrant(Model model, @PathVariable int idFluxEntrant) {
		if (new Integer(idFluxEntrant)!= null) {
			FluxEntrant f =fluxEntrantService.getById(idFluxEntrant);
			if (f != null) {
				//TODO Verification avant suppression
				fluxEntrantService.remove(idFluxEntrant);
			}
		}
		return "redirect:/fluxEntrant/";
	}


}
