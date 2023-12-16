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
@Table(name = "lieu")
public class Lieu{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lieu_id;
	
	private String lieu1;
	
	private String lieu2;
	
	private double distance;
	
	@OneToMany(
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true, 
			   fetch = FetchType.EAGER)
	@JoinColumn(name = "lieu_id")
	List<Operation> operations=new ArrayList<>();

	public int getLieu_id() {
		return lieu_id;
	}

	public void setLieu_id(int lieu_id) {
		this.lieu_id = lieu_id;
	}

	public String getLieu1() {
		return lieu1;
	}

	public void setLieu1(String lieu1) {
		this.lieu1 = lieu1;
	}

	public String getLieu2() {
		return lieu2;
	}

	public void setLieu2(String lieu2) {
		this.lieu2 = lieu2;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
}
