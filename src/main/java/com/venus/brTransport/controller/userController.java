package com.venus.brTransport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.venus.brTransport.model.User;
import com.venus.brTransport.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class userController{
	
	@Autowired
	UserService userService;
	@PostMapping("/saveUser")
	public String saveUser(User user,Model model) {
		userService.saveUser(user);
		model.addAttribute("u",1);
		return "message";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "Inscription";
	}
	@PostMapping("/login")
	public String login(User user,Model model,HttpServletRequest request) {
		User user1=userService.getUserMail(user.getMail());
		if(user1!=null&&user1.getPassword().equals(user.getPassword())) {
			    request.getSession().setAttribute("userId", user1.getUser_id());
			    request.getSession().setAttribute("userPrenom", user1.getPrenom());
			    request.getSession().setAttribute("userNom", user1.getNom());
			    return "redirect:/";
		     }
		else {
		    	return "redirect:/loginE";
		    }
	}
	@GetMapping("/loginE")
	public String loginException(Model model){
		 int i=0;
	     model.addAttribute("val",i);
		 return "Connexion";	
	}
	@GetMapping("/deconnexion")
	public String deconnexion(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	@PostMapping("/updateUser")
	public String updateUser(User user,Model model,HttpServletRequest request) {
		int user_id=(int)request.getSession().getAttribute("userId");
		String nom=user.getNom();
		String prenom=user.getPrenom();
		String adresse=user.getAdresse();
		String telephone=user.getTelephone();
		String email=user.getMail();
		String password=user.getPassword();
		userService.UpdaeUserById(user_id, nom, prenom, adresse, telephone, email, password);
		request.getSession().setAttribute("v", 1);
		return "redirect:/setting";
		}
	@GetMapping("/setting")
	public String setting(Model model,HttpServletRequest request) {
		/*sessions*/
		  String prenom=(String) request.getSession().getAttribute("userPrenom");
		  String nom=(String) request.getSession().getAttribute("userNom");
		  model.addAttribute("userNom", nom);
		  model.addAttribute("userPrenom", prenom);
		  
		int user_id=(int)request.getSession().getAttribute("userId");
		User user=userService.getUserById(user_id);
		model.addAttribute(user);
		int v=0;
		if(request.getSession().getAttribute("v")!=null) {
		   v=(int)request.getSession().getAttribute("v");
		}
		request.getSession().setAttribute("v", null);
		model.addAttribute("v", v);
		
		return "param";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		int user_id=(int)request.getSession().getAttribute("userId");
		userService.deleteUserById(user_id);
		request.getSession().invalidate();
		return "deleteMessage";
	}
}
