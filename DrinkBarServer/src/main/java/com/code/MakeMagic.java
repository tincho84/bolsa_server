package com.code;

import java.util.ArrayList;
import java.util.List;

import com.code.erp.BeersFromCashSystem;
import com.code.erp.CashSystemConnector;

/**
 * Clase que recibe la peticion de la tv
 * Consulta las ventas del ultimo periodo del erp
 * Calcula los nuevos precios en base a esos datos
 * Guarda la información en un archivo de texto en el filesystem
 * Devuelve la información a la tv
 * @author Martin
 *
 */
public class MakeMagic {

	
	public MakeMagic() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo que recibe la peticion de la tv
	 * Consulta las ventas del ultimo periodo del erp
	 * Calcula los nuevos precios en base a esos datos
	 * Guarda la información en un archivo de texto en el filesystem
	 * Devuelve la información a la tv
	 */
	public static List<DrinkToShow> calculateNewPriceAndUpdate(){
		
		//pido las ventas del ultimo periodo
		try {
			CashSystemConnector csc = new CashSystemConnector();
			List<BeersFromCashSystem> beersFromCashSystem = csc.getSoldOfLastPeriod();
		}catch(Exception e) {
			System.out.println("No pudo obtener la info del erp");
		}
		
		//actualizo las cervezas con los nuevos precios
		
		List<Drink> drinks = new ArrayList<>();
		drinks.add(new Drink(1,"Honey","Cerveza honey",100,80,95,100));
		drinks.add(new Drink(2,"Ipa","Cerveza Ipa",100,60,100,100));
		drinks.add(new Drink(3,"Black","Cerveza Black",100,87,100,100));
		drinks.add(new Drink(4,"Pilsen","Cerveza Pilsen",90,13,105,100));
		drinks.add(new Drink(5,"Red","Cerveza red",90,55,100,100));
		drinks.add(new Drink(6,"Red Honey","Cerveza red honey",80,30,95,100));
		drinks.add(new Drink(7,"Black Honey","Cerveza black honey",90,63,95,100));


		List<DrinkToShow> drinkToShow = CalculatePricesHelper.calculateNewPrices(drinks);

		
		return drinkToShow;
				
	}

	/**
	 * Devuelve la información al sistema solicitado cel o pagina web
	 */
	public static void getNewPrices(){
		
	}
	
}
