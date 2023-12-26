package com.venus.brTransport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marchandise")
public class Marchandise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int marchandise_id;
	
	private Double hauteur;
	
	private Double largeur;
	
	private Double longueur;
	
	private Double poids;
	
    private String type;


	public int getMarchandise_id() {
		return marchandise_id;
	}

	public void setMarchandise_id(int marchandise_id) {
		this.marchandise_id = marchandise_id;
	}

	public Double getHauteur() {
		return hauteur;
	}

	public void setHauteur(Double hauteur) {
		this.hauteur = hauteur;
	}

	public Double getLargeur() {
		return largeur;
	}

	public void setLargeur(Double largeur) {
		this.largeur = largeur;
	}

	public Double getLongueur() {
		return longueur;
	}

	public void setLongueur(Double longueur) {
		this.longueur = longueur;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Marchandise{" +
				"marchandise_id=" + marchandise_id +
				", hauteur=" + hauteur +
				", largeur=" + largeur +
				", longueur=" + longueur +
				", poids=" + poids +
				", type='" + type + '\'' +
				'}';
	}
}
