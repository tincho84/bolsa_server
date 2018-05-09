package com.code;


/**
 * Clase con la que le mando la información a los sistemas que solicitan 
 * nuevos precios
 * @author Martin
 *
 */
public class DrinkToShow {

	private int id;
	private String name;
    private String description;

    //litros que tengo actualmente
	private Float stockLiters;
    //litros que vendi
	private Float soldLiters;
    //precio al que se esta vendiendo
	private Float newPrice;
    //precio al que se tendría que vender
	private Float referencePrice;

	private String variation;

	
	
	public DrinkToShow() {
		// TODO Auto-generated constructor stub
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

	public float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getStockLiters() {
		return stockLiters;
	}

	public void setStockLiters(Float stockLiters) {
		this.stockLiters = stockLiters;
	}

	public Float getSoldLiters() {
		return soldLiters;
	}

	public void setSoldLiters(Float soldLiters) {
		this.soldLiters = soldLiters;
	}

	public Float getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(Float referencePrice) {
		this.referencePrice = referencePrice;
	}

	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}	

	
	
}
