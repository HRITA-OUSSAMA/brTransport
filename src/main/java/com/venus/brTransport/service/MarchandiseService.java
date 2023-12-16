package com.venus.brTransport.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.repository.MarchandiseRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MarchandiseService {
	
	@Autowired
	MarchandiseRepository marchandiseRepository;

	public void saveMarchandise(Marchandise marchandise) {
		marchandiseRepository.save(marchandise);
	}
	
	public List<Marchandise> getMarchandisesByAttribute(String hauteur,String largeur,String longueur,String poids,String type,HttpServletRequest request) {
		Marchandise marchandise=new Marchandise();
		  Double hauteur1=(Double) request.getSession().getAttribute(hauteur);
		  Double largeur1=(Double) request.getSession().getAttribute(largeur);
		  Double longueur1=(Double) request.getSession().getAttribute(longueur);
		  Double poids1=(Double) request.getSession().getAttribute(poids);
		  String type1=(String) request.getSession().getAttribute(type);
		  marchandise.setHauteur(hauteur1);
		  marchandise.setLargeur(largeur1);
		  marchandise.setLongueur(longueur1);
		  marchandise.setPoids(poids1);
		  marchandise.setType(type1);
		  List<Marchandise> marchandises=new ArrayList<>();
		  marchandises.add(marchandise);
		  return marchandises;
		
	}
}
