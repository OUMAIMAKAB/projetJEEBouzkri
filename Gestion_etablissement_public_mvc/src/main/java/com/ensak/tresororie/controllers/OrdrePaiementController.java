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

import com.ensak.tresororie.entites.CreditOuvert;
import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.entites.ModePaiement;
import com.ensak.tresororie.entites.OrdrePaiement;
import com.ensak.tresororie.entites.Rubrique;
import com.ensak.tresororie.services.ICreditOuvertService;
import com.ensak.tresororie.services.IExerciceService;
import com.ensak.tresororie.services.IModePaiementService;
import com.ensak.tresororie.services.IOrdrePaiementService;
import com.ensak.tresororie.services.IRubriqueService;

@Controller
@RequestMapping(value="/ordrePaiement")
public class OrdrePaiementController {
	
	@Autowired
	private IOrdrePaiementService ordrePaiementService;
	
	@Autowired
	private IModePaiementService modePaiementService;
	
	@Autowired
	private IExerciceService exerciceService;
	
	@Autowired
	private IRubriqueService rubriqueService;
	
	@Autowired
	private ICreditOuvertService creditOuvertService;
	
	
	@RequestMapping(value="/")
	public String OrdrePaiement(Model model) {
		
		List<OrdrePaiement> ordrePaiements = ordrePaiementService.selectAll();
		if(ordrePaiements==null) {
			ordrePaiements=new ArrayList<OrdrePaiement>();
		}
		model.addAttribute("ordrePaiements", ordrePaiements);
		return "OrdrePaiement/OrdrePaiements";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterOrdrePaiement(Model model) {
		
	OrdrePaiement ordrePaiement=new OrdrePaiement();
	model.addAttribute("ordrePaiement", ordrePaiement);
	

	
	
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
		
		List <ModePaiement> modePaiements= modePaiementService.selectAll();
		if(modePaiements == null) {
			modePaiements= new ArrayList<ModePaiement> ();
		}
		model.addAttribute("modePaiements", modePaiements);
		
	
		return "OrdrePaiement/ajouterOrdrePaiement";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerOrdrePaiement(Model model,@Valid OrdrePaiement ordrePaiement,BindingResult bindingResult) {
		
if(bindingResult.hasErrors()) {
			
			
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
			
			List <ModePaiement> modePaiements= modePaiementService.selectAll();
			if(modePaiements == null) {
				modePaiements= new ArrayList<ModePaiement> ();
			}
			model.addAttribute("modePaiements", modePaiements);
			
			return "OrdrePaiement/ajouterOrdrePaiement";
		}
		
    if(ordrePaiement != null) {
  	  
    	try {
   	 
        ModePaiement modePaiement=modePaiementService.getById(ordrePaiement.getModePaiement().getIdModePaiement());
   	 Boolean isUsed=modePaiement.getIsUsed();
   	 if(isUsed==false) {
   		    int idRubrique=ordrePaiement.getRubrique().getIdRubrique();
	    	 Rubrique rubrique=rubriqueService.getById(idRubrique);
	    	
	    	 CreditOuvert creditOuvert=creditOuvertService.getCreditOuvertDeLaRubrique(rubrique);
	    	
	    	 double sommeMax=creditOuvert.getSomme();
	    	 double sommeExistante=creditOuvert.getSommeConsomme();
	    	 
	         double sommeCalcule=modePaiement.getMontant()+sommeExistante;
	         
	         if(sommeCalcule>sommeMax) {
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
	    			
	    			List <ModePaiement> modePaiements= modePaiementService.selectAll();
	    			if(modePaiements == null) {
	    				modePaiements= new ArrayList<ModePaiement> ();
	    			}
	    			model.addAttribute("modePaiements", modePaiements);
	        	 throw new Exception("vous avez dépassé la sommeMax pour cette rubrique");
	         }
	         
	         creditOuvert.setSommeConsomme(sommeCalcule);
	         modePaiement.setIsUsed(true);
	         creditOuvertService.update(creditOuvert);
	         modePaiementService.update(modePaiement);
	         ordrePaiementService.save(ordrePaiement);
	      
   	 }else {
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
		
		List <ModePaiement> modePaiements= modePaiementService.selectAll();
		if(modePaiements == null) {
			modePaiements= new ArrayList<ModePaiement> ();
		}
		model.addAttribute("modePaiements", modePaiements);
   		 throw new Exception("Ce mode de paiement est déjà utilisé");
   	 }
   	 }catch (Exception e) {
    	 model.addAttribute("exception", e.getMessage());
    	 	
		return "OrdrePaiement/ajouterOrdrePaiement";
    	 
	}
   	 
    }
    
    
		
		return "redirect:/ordrePaiement/";
	   	 
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idOrdrePaiement}")
	public String modifierOrdrePaiement(Model model, @PathVariable int idOrdrePaiement) {
		
		
		
		List <Exercice> exercices= exerciceService.selectAll();
		if(exercices == null) {
			exercices= new ArrayList<Exercice> ();
		}
		model.addAttribute("exercices", exercices);
		 
			OrdrePaiement OrdrePaiement = ordrePaiementService.getById(idOrdrePaiement);
			
			List <Rubrique> rubriques= rubriqueService.getRubriquesDepense();
			if(rubriques == null) {
				rubriques= new ArrayList<Rubrique> ();
			}
			model.addAttribute("rubriques", rubriques);
			
			List <ModePaiement> modePaiements= modePaiementService.selectAll();
			if(modePaiements == null) {
				modePaiements= new ArrayList<ModePaiement> ();
			}
			model.addAttribute("modePaiements", modePaiements);
			
		
			
			if (OrdrePaiement != null) {
				model.addAttribute("ordrePaiement", OrdrePaiement);
				
			}
		
		return "OrdrePaiement/modifierOrdrePaiement";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,OrdrePaiement OrdrePaiement) {
		     if(OrdrePaiement != null) {
		    	 ordrePaiementService.update(OrdrePaiement);
		     }
			return "redirect:/ordrePaiement/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idOrdrePaiement}")
	public String supprimerOrdrePaiement(Model model, @PathVariable int idOrdrePaiement) {
		if (new Integer(idOrdrePaiement)!= null) {
			OrdrePaiement f =ordrePaiementService.getById(idOrdrePaiement);
			if (f != null) {
				//TODO Verification avant suppression
				ordrePaiementService.remove(idOrdrePaiement);
			}
		}
		return "redirect:/ordrePaiement/";
	}



}
