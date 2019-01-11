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

import com.ensak.tresororie.entites.Rubrique;
import com.ensak.tresororie.services.IRubriqueService;

@Controller
@RequestMapping(value="/rubrique")
public class RubriqueController {

	 
	@Autowired
	private IRubriqueService rubriqueService;
	
	
	@RequestMapping(value="/")
	public String Rubrique(Model model) {
		
		List<Rubrique> rubriques = rubriqueService.selectAll();
		if(rubriques==null) {
			rubriques=new ArrayList<Rubrique>();
		}
		model.addAttribute("rubriques", rubriques);
		return "Rubrique/Rubriques";
	}
	
	
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterRubrique(Model model) {
		Rubrique rubrique=new Rubrique();
		model.addAttribute("rubrique", rubrique);
		String [] types= {"Depense","Recette"};
		model.addAttribute("types",types);
		String [] typesBudget= {"Fonctionnel","Investissement"};
		model.addAttribute("typesBudget",typesBudget);
		return "Rubrique/ajouterRubrique";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerRubrique(Model model,@Valid Rubrique rubrique,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			String [] types= {"Depense","Recette"};
			model.addAttribute("types",types);
			String [] typesBudget= {"Fonctionnel","Investissement"};
			model.addAttribute("typesBudget",typesBudget);
			return "Rubrique/ajouterRubrique";
		}
		try {
	     if(rubrique != null) {
	    	 
	    	 Rubrique et=rubriqueService.getById(rubrique.getIdRubrique());
	    	 if(et==null) {
	    		 rubriqueService.save(rubrique);
	    		 
	    	 }else {
	    		    String [] types= {"Depense","Recette"};
	    			model.addAttribute("types",types);
	    			String [] typesBudget= {"Fonctionnel","Investissement"};
	    			model.addAttribute("typesBudget",typesBudget);
	    		 throw new Exception("Cette Rubrique existe déjà");
	    			
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "Rubrique/ajouterRubrique";
		}
		return "redirect:/rubrique/";
	}
	
	
	
	
	@RequestMapping(value = "/modifier/{idRubrique}")
	public String modifierRubrique(Model model, @PathVariable int idRubrique) {
		
		String [] types= {"Depense","Recette"};
		model.addAttribute("types",types);
		String [] typesBudget= {"Fonctionnel","Investissement"};
		model.addAttribute("typesBudget",typesBudget);
			Rubrique rubrique = rubriqueService.getById(idRubrique);
			if (rubrique != null) {
				model.addAttribute("rubrique", rubrique);
			}
		
		return "Rubrique/modifierRubrique";
	}
	
	
	
	@RequestMapping(value = "/enregistrerModification",method=RequestMethod.POST)
   public String enregistrerModification(Model model,Rubrique rubrique) {
		     if(rubrique != null) {
		    	 rubriqueService.update(rubrique);
		     }
			return "redirect:/rubrique/";
	}
	
	
	
	@RequestMapping(value = "/supprimer/{idRubrique}")
	public String supprimerRubrique(Model model, @PathVariable int idRubrique) {
		if (new Integer(idRubrique)!= null) {
			Rubrique f =rubriqueService.getById(idRubrique);
			if (f != null) {
				//TODO Verification avant suppression
				rubriqueService.remove(idRubrique);
			}
		}
		return "redirect:/rubrique/";
	}

	
	
	

}
