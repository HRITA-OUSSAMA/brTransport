package com.venus.brTransport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.venus.brTransport.model.Contact;


import com.venus.brTransport.service.MessageService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class contactController {
	@Autowired
	MessageService messageService;
	
    @PostMapping("/message")
    public String Message1(Contact contact,Model model,HttpServletRequest request) {
    	String prenom=(String) request.getSession().getAttribute("userPrenom");
		String nom=(String) request.getSession().getAttribute("userNom");
		model.addAttribute("userNom", nom);
		model.addAttribute("userPrenom", prenom);
  
    	contact.setVue(0);
    	messageService.saveMessage(contact);
    	model.addAttribute("u",4);
    	return "message";
    }
}
