package com.venus.brTransport.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.brTransport.model.Marchandise;
import com.venus.brTransport.repository.MarchandiseRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MarchandiseService {

	private final MarchandiseRepository marchandiseRepository;

	public MarchandiseService(MarchandiseRepository marchandiseRepository) {
		this.marchandiseRepository = marchandiseRepository;
	}

	public Marchandise saveMarchandise(Marchandise marchandise) {
        return marchandiseRepository.save(marchandise);
	}
	
	public List<Marchandise> getMarchandisesByAttribute(String hauteur,String largeur,String longueur,String poids,String type,HttpServletRequest request) {

		Marchandise marchandise=new Marchandise();
		HttpSession session= request.getSession();
		Double hauteur1=(Double) session.getAttribute(hauteur);
		Double largeur1=(Double) session.getAttribute(largeur);
		Double longueur1=(Double) session.getAttribute(longueur);
		Double poids1=(Double) session.getAttribute(poids);
		String type1=(String) session.getAttribute(type);
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
