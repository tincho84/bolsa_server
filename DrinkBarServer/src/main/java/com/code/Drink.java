package com.code;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Clase con la que voy a ir a buscar al sistema de facturación
 * @author Martin
 *
 */
public class Drink implements Comparable<Object>{

	 
	private Integer id;
    private String name;
    private String description;

    //litros que tengo actualmente
	private Float stockLiters;
    //litros que vendi
	private Float soldLiters;
    //precio al que se esta vendiendo
	private Float actualPrice;
    //precio al que se tendría que vender
	private Float referencePrice;


    public Drink() {
    }
    
    public Drink(int id, String name, String description, float stockLiters,float soldLiters, float actualPrice,float referencePrice) {
            this.name = name;
            this.id = id;
            this.description = description;
            this.soldLiters = soldLiters;
            this.stockLiters = stockLiters;
            this.actualPrice = actualPrice;
            this.referencePrice = referencePrice;            		
    }
    
    
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Float getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Float actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Float getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(Float referencePrice) {
		this.referencePrice = referencePrice;
	}

	@Override
    public String toString() {
            try {
                    return new JSONObject().put("id", id).put("name", name).put("description", description)
                    		.put("stockLiters", stockLiters).put("soldLiters", soldLiters)
                    		.put("actualPrice", actualPrice).put("referencePrice", referencePrice).toString();

            } catch (JSONException e) {
                    return null;
            }
    }

	@Override
	public int compareTo(Object arg0) {
		Drink d = (Drink)arg0;
		if (d.getStockLiters() < this.getStockLiters())
			return 1;
		if (d.getStockLiters() > this.getStockLiters())
			return -1;
		return 0;
	}
	
}
