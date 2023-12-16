package com.venus.brTransport.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
	   
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int facture_id;
	    
        private Double prix;
	    
        private String description;
        
        private int operation_id; 	    
}
