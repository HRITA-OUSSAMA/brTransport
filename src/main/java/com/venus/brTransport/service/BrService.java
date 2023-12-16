package com.venus.brTransport.service;

import org.springframework.stereotype.Service;

@Service
public class BrService {
       
	public Double calculatePrice(String type,Double hauteur,Double largeur,Double longueur,Double poids,Double distance) {
		Double a=0.0;
		if(type.equals("MARCHANDISES GENERALES")) {
			a=0.2;
		}
		else if (type.equals("TRANSPORT EXCEPTIONNEL")) {
			a=0.3;
		}
		else if (type.equals("MATIERES DANGEREUSES")) {
			a=0.5;
		}
		return a*hauteur*largeur*longueur*distance*poids*1/10000000;
	}
}
