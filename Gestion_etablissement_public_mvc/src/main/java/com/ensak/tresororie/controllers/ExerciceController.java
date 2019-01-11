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

import com.ensak.tresororie.entites.Exercice;
import com.ensak.tresororie.services.IExerciceService;

@Controller
@RequestMapping(value="/exercice")
public class ExerciceController {

	@Autowired
	private IExerciceService exerciceService;
	
	
	
	
	@RequestMapping(value="/")
	public String Exercice(Model model) {
		
		List<Exercice> exercices = exerciceService.selectAll();
		if(exercices==null) {
			exercices=new ArrayList<Exercice>();
		}
		model.addAttribute("exercices", exercices);
		return "Exercice/Exercices";
	}
	
	
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterExercice(Model model) {
		Exercice exercice=new Exercice();
		model.addAttribute("exercice", exercice);
		
		return "Exercice/ajouterExercice";
	}
	
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String enregistrerExercice(Model model,@Valid Exercice exercice,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			return "Exercice/ajouterExercice";
		}
		try {
	     if(exercice != null) {
	    	 
	    	 Exercice et=exerciceService.getById(exercice.getAnnee());
	    	 if(et==null) {
	    		 exerciceService.save(exercice);
	    		 
	    	 }else {
	    		 throw new Exception("Cet exercice existe déjà");
	    	 }
	    	 
	     }
	     }
	     catch (Exception e) {
	    	 model.addAttribute("exception", e.getMessage());
			return "Exercice/ajouterExercice";
		}
		return "redirect:/exercice/";
	}
	

	
	
	@RequestMapping(value = "/supprimer/{idExercice}")
	public String supprimerExercice(Model model, @PathVariable int idExercice) {
		if (new Integer(idExercice)!= null) {
			Exercice f =exerciceService.getById(idExercice);
			if (f != null) {
				//TODO Verification avant suppression
				exerciceService.remove(idExercice);
			}
		}
		return "redirect:/exercice/";
	}

}
