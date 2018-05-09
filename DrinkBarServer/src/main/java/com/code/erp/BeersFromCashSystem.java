package com.code.erp;

public class BeersFromCashSystem {

	private int id;
	private String name;
	private int stock;
	
	//lo que se vendio en el periodo solicitado
	private float sold;
	
	public BeersFromCashSystem() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getSold() {
		return sold;
	}
	public void setSold(float sold) {
		this.sold = sold;
	}
	
	
}
