package com.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CalculatePricesHelper {

	
	/*
	  Si la diferencia de litros es <10 entonces subo un 4%
	  Si la diferencia de litros esta entre 10 y 20 subo 2 %
	  Si la diferencia de litros esta entre 20 y 30 precio referencia
	  Si la diferencia de litros esta entre 30 y 40 bajo 2 %
	  Si la diferencia de litros es >40 entonces bajo un 4%
	  El % de variación es contra el precio anterior
	 */
	public static ArrayList<DrinkToShow> calculateNewPrices(List<Drink> drinksFromSystem) {
		
		ArrayList<Float> diff_lt = new ArrayList<Float>();
		ArrayList<Float> diff_price = new ArrayList<Float>();
	    
		DrinkToShow drinkToShow;
		ArrayList<DrinkToShow> drinksToShowTemp = new ArrayList<DrinkToShow>();

		Iterator<Drink> it = drinksFromSystem.iterator();
		while (it.hasNext()) {
			
			Drink drink = it.next();
			drinkToShow = new DrinkToShow();
			Float diff_lt_actual = drink.getStockLiters() - drink.getSoldLiters();
			diff_lt.add( diff_lt_actual );
			diff_price.add( drink.getActualPrice() - drink.getReferencePrice() );

			drinkToShow.setId( drink.getId() );
			drinkToShow.setName( drink.getName() );

			if (diff_lt_actual < 10) {
		        drinkToShow.setNewPrice( Math.round(drink.getActualPrice()*1.04) );
		        drinkToShow.setVariation( getPercent(drinkToShow.getNewPrice(),drink.getActualPrice()) );//"+0.4";
		      }else if (diff_lt_actual < 20) {
		        drinkToShow.setNewPrice( Math.round(drink.getActualPrice()*1.02) );
		        drinkToShow.setVariation( getPercent(drinkToShow.getNewPrice(),drink.getActualPrice()) );//"+0.2";
		      }else if (diff_lt_actual < 30) {
		        drinkToShow.setNewPrice( Math.round(drink.getReferencePrice()) );
		        drinkToShow.setVariation( getPercent(drinkToShow.getNewPrice(),drink.getActualPrice()) );//"0";
		      }else if (diff_lt_actual < 40) {
		        drinkToShow.setNewPrice( Math.round(drink.getActualPrice()*0.98) );
		        drinkToShow.setVariation( getPercent(drinkToShow.getNewPrice(),drink.getActualPrice()) );//"-0.2";
		      }else {
		        drinkToShow.setNewPrice( Math.round(drink.getActualPrice()*0.96) );
		        drinkToShow.setVariation( getPercent(drinkToShow.getNewPrice(),drink.getActualPrice()) );//"-0.4";
		      } 

		      drinksToShowTemp.add( drinkToShow );
			
		}
		
//	    var lessStock = 500;var lessStockId;
//	    var moreStock = 0;var moreStockId;
//
//	    //recorro devuelta para saber cual es la de menor stock y la de mayor stock
//	    for (var _i = 0; _i < drinksFromSystem.length; _i++) {
//	      var drink = drinksFromSystem[_i];
//
//	      if (diff_lt[_i]<lessStock){
//	        lessStock=diff_lt[_i];
//	        lessStockId = _i;
//	      }
//	      if (diff_lt[_i]>moreStock){
//	        moreStock=diff_lt[_i];
//	        moreStockId = _i;
//	      }
//	    }
	
		return drinksToShowTemp;

	}
	
	  /*


	  loadDrinkss(drinksService:Drink[]):DrinkToShow[]{

	    var diff_lt:number[] = [];
	    var diff_price:number[] = [];
	    var drinkToShow;
	    var drinksToShowTemp:DrinkToShow[]=[];

	    for (var _i = 0; _i < drinksService.length; _i++) {
	      drinkToShow = new DrinkToShow();
	      var drink = drinksService[_i];
	      diff_lt[_i] = drink.stockLiters -drink.soldLiters;
	      diff_price[_i] = drink.actualPrice -drink.referencePrice;

	      drinkToShow.id = drink.id;
	      drinkToShow.name = drink.name;

	      if (diff_lt[_i] < 10) {
	        drinkToShow.newPrice = Math.round(drink.actualPrice*1.04);
	        drinkToShow.variation = this.getPercent(drinkToShow.newPrice,drink.actualPrice);//"+0.4";
	      }else if (diff_lt[_i] < 20) {
	        drinkToShow.newPrice = Math.round(drink.actualPrice*1.02);
	        drinkToShow.variation = this.getPercent(drinkToShow.newPrice,drink.actualPrice);//"+0.2";
	      }else if (diff_lt[_i] < 30) {
	        drinkToShow.newPrice = Math.round(drink.referencePrice);
	        drinkToShow.variation = this.getPercent(drinkToShow.newPrice,drink.actualPrice);//"0";
	      }else if (diff_lt[_i] < 40) {
	        drinkToShow.newPrice = Math.round(drink.actualPrice*0.98);
	        drinkToShow.variation = this.getPercent(drinkToShow.newPrice,drink.actualPrice);//"-0.2";
	      }else {
	        drinkToShow.newPrice = Math.round(drink.actualPrice*0.96);
	        drinkToShow.variation = this.getPercent(drinkToShow.newPrice,drink.actualPrice);//"-0.4";
	      } 

	      drinksToShowTemp[_i] = drinkToShow;
	      
	    }

	    var lessStock = 500;var lessStockId;
	    var moreStock = 0;var moreStockId;

	    //recorro devuelta para saber cual es la de menor stock y la de mayor stock
	    for (var _i = 0; _i < drinksService.length; _i++) {
	      var drink = drinksService[_i];

	      if (diff_lt[_i]<lessStock){
	        lessStock=diff_lt[_i];
	        lessStockId = _i;
	      }
	      if (diff_lt[_i]>moreStock){
	        moreStock=diff_lt[_i];
	        moreStockId = _i;
	      }


	   //   drinkToShow.newPrice = 20;
	   //   drinkToShow.variation = 20;

	    }
	    return drinksToShowTemp;

	  }
	  
	    getPercent(nuevoPrecio:number,precioActual:number):number{
    return  ((nuevoPrecio*100)/precioActual);
  }
	*/
	
	
	public static String getPercent(Float nuevoPrecio, Float precioActual){
		return  Float.toString(((nuevoPrecio*100)/precioActual));
	}
	
	
	
	//los grupos pueden ser 3 o 5
	private static int cantGrupos=3;
	//precio que se va a agregar al precio defecto para arriba y abajo
	private int initialPriceVariation=5;
	
	private static List<List<Drink>> beerGroups=null;
	
	/*
	  Si la diferencia de litros es <10 entonces subo un 4%
	  Si la diferencia de litros esta entre 10 y 20 subo 2 %
	  Si la diferencia de litros esta entre 20 y 30 precio referencia
	  Si la diferencia de litros esta entre 30 y 40 bajo 2 %
	  Si la diferencia de litros es >40 entonces bajo un 4%
	  El % de variación es contra el precio anterior
	 */
/*	public static ArrayList<DrinkToShow> calculateNewPrices2(List<Drink> drinksFromSystem) {
		
		//creo los grupos iniciales de cerveza
		if (beerGroups==null) {

			beerGroups = new ArrayList<List<Drink>>();
			
			//cantidad de canillas que tengo disponibles
			int cantCanillas = drinksFromSystem.size();
			int beersByGroup = (int)(cantCanillas / cantGrupos);
			Collections.sort(drinksFromSystem);
						
			List<Drink> grupox;
			
			int i=0;
			int initIndex=0;
			while (i<cantGrupos) {
				
				if (initIndex+beersByGroup>cantCanillas)
					grupox = drinksFromSystem.subList(initIndex,cantCanillas);
				else
					grupox = drinksFromSystem.subList(initIndex,initIndex+beersByGroup);
				
				initIndex+=beersByGroup;
				beerGroups.add(grupox);
				i++;
			}
			
			if (cantGrupos==3) {
				
				
			}else{
				
			}
			
		}
		
	
		return drinksToShowTemp;

	}
*/
	
	
}
