package com.venus.brTransport.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.venus.brTransport.model.Lieu;
import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.model.Operation;
import com.venus.brTransport.model.OperationCard;
import com.venus.brTransport.model.User;
import com.venus.brTransport.service.BrService;
import com.venus.brTransport.service.LieuService;
import com.venus.brTransport.service.MarchandiseService;
import com.venus.brTransport.service.OperationService;
import com.venus.brTransport.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class operationController {
	
	  @Autowired
	  LieuService lieuService;
	  @Autowired
	  BrService brService;
	  @Autowired 
	  OperationService operationService;
	  @Autowired
	  MarchandiseService marchandiseService;
	  @Autowired
	  UserService userService;
	  
	  @GetMapping("/bookTransportS1")
      public String bookTransportS1(Model model,HttpServletRequest request) {
	  /*sessions*/
      if(request.getSession().getAttribute("userPrenom")!=null && request.getSession().getAttribute("userNom")!=null) {
	  String prenom=(String) request.getSession().getAttribute("userPrenom");
	  String nom=(String) request.getSession().getAttribute("userNom");
	  model.addAttribute("userNom", nom);
	  model.addAttribute("userPrenom", prenom);}
	  /*lieu*/
	  Iterable<Lieu> lieux=lieuService.getLieux();
	  model.addAttribute("lieux", lieux);
	  return "bookTransportS1";
  }
	 @PostMapping("/bookTransportS1Submit")
	  public String bookTransportS1Submit(Lieu lieu,HttpServletRequest request) {
		  String lieu1=lieu.getLieu1();
		  String lieu2=lieu.getLieu2();
		  Double distance=lieuService.getLieuEnDeuxParam(lieu1, lieu2).getDistance();
		  int lieu_id=lieuService.getLieuEnDeuxParam(lieu1, lieu2).getLieu_id();
		  request.getSession().setAttribute("distance", distance);
		  request.getSession().setAttribute("lieu_id", lieu_id);
		  return "redirect:/bookTransportS2";
	  }
	  
	  @PostMapping("/bookTransportS2Submit")
	  public String bookTransportS2Submit(Marchandise marchandise,HttpServletRequest request){
		  String type=marchandise.getType();
		  request.getSession().setAttribute("type", type);
		  return "redirect:/bookTransportS3";
	  }
	  
	  @PostMapping("/bookTransportS3Submit")
	  public String bookTransportS3Submit(Marchandise marchandise,HttpServletRequest request) {
		  Double hauteur=marchandise.getHauteur();
		  Double largeur=marchandise.getLargeur();
		  Double longueur=marchandise.getLongueur();
		  Double poids=marchandise.getPoids();
		  request.getSession().setAttribute("hauteur", hauteur);
		  request.getSession().setAttribute("largeur", largeur);
		  request.getSession().setAttribute("longueur", longueur);
		  request.getSession().setAttribute("poids", poids);
		  return "redirect:/estimation";
	  }
	  
	  @GetMapping("/estimation")
      public String estimation(Model model,HttpServletRequest request) {
		  /*session header*/
		  if(request.getSession().getAttribute("userPrenom")!=null && request.getSession().getAttribute("userNom")!=null) {
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  model.addAttribute("u", 1);
		  }
		  /*session for price*/
		  Double hauteur=(Double) request.getSession().getAttribute("hauteur");
		  Double largeur=(Double) request.getSession().getAttribute("largeur");
		  Double longueur=(Double) request.getSession().getAttribute("longueur");
		  Double poids=(Double) request.getSession().getAttribute("poids");
		  String type=(String) request.getSession().getAttribute("type");
		  Double distance=(Double) request.getSession().getAttribute("distance");
		  Double price=brService.calculatePrice(type, hauteur, largeur, longueur,poids,distance);
		  request.getSession().setAttribute("price", price);
		  model.addAttribute("price",price);
   	  return "Estimation";
     }
	  @GetMapping("/bookTransportS2")
     public String bookTransportS2(Model model,HttpServletRequest request) {
		  if(request.getSession().getAttribute("userPrenom")!=null && request.getSession().getAttribute("userNom")!=null) {
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);}
   	  return "bookTransportS2";
     }
	  
	  @GetMapping("/bookTransportS3")
     public String bookTransportS3(Model model,HttpServletRequest request) {
		  if(request.getSession().getAttribute("userPrenom")!=null && request.getSession().getAttribute("userNom")!=null) {
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);}
   	  return "bookTransportS3";
     }
	  @GetMapping("/reserver_transport")
     public String reserver_transport(HttpServletRequest request) {
		  if(request.getSession().getAttribute("userId")==null) {
			  return "redirect:/connexion";
		  }
		  else {
			  return "redirect:/bookTransportS1";
		  }
     }
	  
	 @PostMapping("/addOperation")
	 public String addOperation(Model model,HttpServletRequest request) {
		 /*session header*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  List<Marchandise> marchandises=marchandiseService.getMarchandisesByAttribute("hauteur", "largeur", "longueur", "poids", "type", request);
		  Operation operation=operationService.getOperationByAttribute("userId","lieu_id", "Pas confirmé",marchandises, request);
		  operationService.saveOperation(operation);
		  model.addAttribute("u", 2);
		 return "message";
	 }
	 
	 @GetMapping("/operation")
	 public String operation(Model model,HttpServletRequest request) {
		 /*session header*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  int user_id=(int) request.getSession().getAttribute("userId");
		  List<OperationCard> operationCards=operationService.getOperationsCards(user_id);
		  model.addAttribute("operationCards", operationCards);
		  return "operations1";
	 }
	 
	 @PostMapping("/paiement/{id}")
	 public String paiementById(@PathVariable("id") final int id,Model model,HttpServletRequest request) {
		  request.getSession().setAttribute("operation_id", id);
		  return "redirect:/paiement";
	 }
	 @GetMapping("/paiement")
	 public String paiement(Model model,HttpServletRequest request){
		 /*session header*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  model.addAttribute("i", 2);
		  return "paiement";
	 }
	 @GetMapping("/EstimationPaiement")
	 public String EstimationPaiement(Model model,HttpServletRequest request) {
		 /*session header*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  model.addAttribute("i", 1);
		  return "paiement";
	 }
	 @PostMapping("/payer1")
	 public String payer1(Model model,HttpServletRequest request) {
		 /*session header*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		 List<Marchandise> marchandises=marchandiseService.getMarchandisesByAttribute("hauteur", "largeur", "longueur", "poids", "type", request);
		  Operation operation=operationService.getOperationByAttribute("userId","lieu_id", "En cours",marchandises, request);
		  operationService.saveOperation(operation);
		  model.addAttribute("u", 3);
		  return "message";
           
	 }
	 @PostMapping("/payer2")
	 public String payer2(Model model,HttpServletRequest request) {
		 /*session header*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  int operation_id=(int)request.getSession().getAttribute("operation_id");
          operationService.UpdataOperarionStatusById("En cours",operation_id);
		  model.addAttribute("u", 3);
		  return "message";
           
	 }
	 @PostMapping("/deleteOperation/{id}")
	 public String deleteOperation(@PathVariable("id") final int id) {
		 operationService.deleteOperationById(id);
		 return "redirect:/operation";
	 }
}
