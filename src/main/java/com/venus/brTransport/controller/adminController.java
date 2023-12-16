package com.venus.brTransport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.venus.brTransport.model.Contact;
import com.venus.brTransport.model.Lieu;
import com.venus.brTransport.model.Operation;
import com.venus.brTransport.model.OperationAdminCard;
import com.venus.brTransport.model.Responsable;
import com.venus.brTransport.service.AdminService;
import com.venus.brTransport.service.LieuService;
import com.venus.brTransport.service.MessageService;
import com.venus.brTransport.service.OperationService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class adminController {
     @Autowired
     AdminService adminService;
     @Autowired
     MessageService messageService;
     @Autowired
     OperationService operationService;
     @Autowired
     LieuService lieuService;
     @PostMapping("/adminConnexion")
     public String adminConnexion(Responsable responsable,Model model,HttpServletRequest request) {
    	   Responsable responsable2=adminService.getResponsableByEmail(responsable.getEmail());
    	   if(responsable2!=null && responsable2.getPassword().equals(responsable.getPassword())) {
    		   request.getSession().setAttribute("admin_nom",responsable2.getNom());
    		   request.getSession().setAttribute("admin_prenom",responsable2.getPrenom());
    		   return "redirect:/Admin/operations";   
    	   }
    	   else {
    		   return "redirect:/Admin";
    	   }
     }
     @GetMapping("/Admin")
     public String Admin() {
    	 return "connexionAdmin";
     }
     @GetMapping("/Admin/operations")
     public String operationsAdmin(Model model,HttpServletRequest request) {
    	 String nom=(String) request.getSession().getAttribute("admin_nom");
    	 String prenom=(String) request.getSession().getAttribute("admin_prenom");
         model.addAttribute("nom", nom);
         model.addAttribute("prenom",prenom);
         int n=messageService.getMessagesNoVueNumber();
         model.addAttribute("n",n);
         Iterable<Contact> contacts=messageService.getMessageNonVue();
         model.addAttribute("contacts",contacts);
         List<OperationAdminCard> operationAdminCards=operationService.getOperationAdminCards();
         model.addAttribute("operations", operationAdminCards);
         return "operationsAdmin";
     }
     @GetMapping("/Admin/Contact")
     public String contact(Model model,HttpServletRequest request){
    	 String nom=(String) request.getSession().getAttribute("admin_nom");
    	 String prenom=(String) request.getSession().getAttribute("admin_prenom");
         model.addAttribute("nom", nom);
         model.addAttribute("prenom",prenom);
         int n=messageService.getMessagesNoVueNumber();
         model.addAttribute("n",n);
         Iterable<Contact> contacts1=messageService.getMessageNonVue();
         model.addAttribute("contacts",contacts1);
         
         Iterable<Contact> contacts=messageService.getMessages();
         model.addAttribute("contacts", contacts);
    	 return "AdminContact";
     }
     @GetMapping("/Admin/ajouterLigne")
     public String ajouterLigne(Model model,HttpServletRequest request) {
    	 String nom=(String) request.getSession().getAttribute("admin_nom");
    	 String prenom=(String) request.getSession().getAttribute("admin_prenom");
         model.addAttribute("nom", nom);
         model.addAttribute("prenom",prenom);
         int n=messageService.getMessagesNoVueNumber();
         model.addAttribute("n",n);
         Iterable<Contact> contacts=messageService.getMessageNonVue();
         model.addAttribute("contacts",contacts);
         
    	 return "ajouterLigne";
     }
     @PostMapping("/ajouterLigne")
     public String ajouterLignebyAdmin(Lieu lieu) {
    	 lieuService.saveLieux(lieu);
    	 return("redirect:/Admin/ajouterLigne");
     }
     @GetMapping("/Admin/analytics")
     public String analytics(Model model,HttpServletRequest request) {
    	 String nom=(String) request.getSession().getAttribute("admin_nom");
    	 String prenom=(String) request.getSession().getAttribute("admin_prenom");
         model.addAttribute("nom", nom);
         model.addAttribute("prenom",prenom);
         int n=messageService.getMessagesNoVueNumber();
         model.addAttribute("n",n);
         Iterable<Contact> contacts=messageService.getMessageNonVue();
         model.addAttribute("contacts",contacts);
         
    	 List<Operation> operations=(List<Operation>) operationService.getOperations();
    	 int j=0;
    	 for(int i=0;i<operations.size();i++) {
    		 if(operations.get(i).getStatus().equals("Pas confirmé")){
    			 j=j+1;
    		 }
    	 }
    	 int p=operations.size()-j;
    	 model.addAttribute("j",j);
    	 model.addAttribute("p",p);
    	 return "Analyse";
     }
     @PostMapping("/Encours/{id}")
     public String Encours(@PathVariable("id") final int id,Model model,HttpServletRequest request) {
    	 String nom=(String) request.getSession().getAttribute("admin_nom");
    	 String prenom=(String) request.getSession().getAttribute("admin_prenom");
         model.addAttribute("nom", nom);
         model.addAttribute("prenom",prenom);
         int n=messageService.getMessagesNoVueNumber();
         model.addAttribute("n",n);
         Iterable<Contact> contacts=messageService.getMessageNonVue();
         model.addAttribute("contacts",contacts);
    	 operationService.UpdataOperarionStatusById("En cours", id);
    	 return "redirect:/Admin/operations";
     }
     @PostMapping("/Effectuer/{id}")
     public String Effectuer(@PathVariable("id") final int id,Model model,HttpServletRequest request) {
    	 String nom=(String) request.getSession().getAttribute("admin_nom");
    	 String prenom=(String) request.getSession().getAttribute("admin_prenom");
         model.addAttribute("nom", nom);
         model.addAttribute("prenom",prenom);
         int n=messageService.getMessagesNoVueNumber();
         model.addAttribute("n",n);
         Iterable<Contact> contacts=messageService.getMessageNonVue();
         model.addAttribute("contacts",contacts);
    	 operationService.UpdataOperarionStatusById("Effectué avec succès", id);
    	 return "redirect:/Admin/operations";
     }
     
}
