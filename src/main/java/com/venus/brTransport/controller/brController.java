package com.venus.brTransport.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class brController {

	@GetMapping({"/","/accueil"})
	public String accueil(Model model, HttpServletRequest request) {
		String prenom = (String) request.getSession().getAttribute("userPrenom");
		String nom = (String) request.getSession().getAttribute("userNom");

		// Ajouter des logs pour déboguer
		System.out.println("UserPrenom from Session: " + prenom);
		System.out.println("UserNom from Session: " + nom);

		model.addAttribute("userNom", nom);
		model.addAttribute("userPrenom", prenom);

		return "Accueil";
	}
	  
	  @GetMapping("/connexion")
      public String connexion() {
    	  return "Connexion";
      }
	  
	  @GetMapping("/contact")
      public String contact(Model model,HttpServletRequest request) {
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
    	  return "Contact";
      }	  
}
