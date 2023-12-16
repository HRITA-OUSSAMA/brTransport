package com.venus.brTransport.model;

public class OperationCard {
	
	private int operation_id;
	private String status;
	private String lieu1;
	private String lieu2;
    private int marchandise_id;
    
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
	public int getMarchandise_id() {
		return marchandise_id;
	}
	public void setMarchandise_id(int marchandise_id) {
		this.marchandise_id = marchandise_id;
	}
    
    
}
