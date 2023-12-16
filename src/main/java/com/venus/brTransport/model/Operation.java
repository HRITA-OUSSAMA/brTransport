package com.venus.brTransport.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "operation_id")
        private int operation_id;
	    
        private String status;  
	    
	    private int user_id;
	    
	    private int lieu_id;
	    
	    @OneToMany(
				   cascade = CascadeType.ALL, 
				   orphanRemoval = true, 
				   fetch = FetchType.EAGER)
		@JoinColumn(name = "operation_id")
	    List<Facture> factures=new ArrayList<>();
	    
	    @OneToMany(
				   cascade = CascadeType.ALL, 
				   orphanRemoval = true, 
				   fetch = FetchType.EAGER)
		@JoinColumn(name = "operation_id")
	    List<Marchandise> marchandises=new ArrayList<>();

		public int getOperation_id() {
			return operation_id;
		}

		public void setOperation_id(int operation_id) {
			this.operation_id = operation_id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public int getLieu_id() {
			return lieu_id;
		}

		public void setLieu_id(int lieu_id) {
			this.lieu_id = lieu_id;
		}

		public List<Facture> getFactures() {
			return factures;
		}

		public void setFactures(List<Facture> factures) {
			this.factures = factures;
		}

		public List<Marchandise> getMarchandises() {
			return marchandises;
		}

		public void setMarchandises(List<Marchandise> marchandises) {
			this.marchandises = marchandises;
		}

		
	    
		
	    
	    
}
