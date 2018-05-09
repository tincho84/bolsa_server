package com.code.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.code.CalculatePricesHelper;
import com.code.Drink;
import com.code.DrinkToShow;
import com.code.MakeMagic;

/**
 * Servicios rest disponibles para consumir contra el dispatcher
 * @author martin
 *
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DrinkRestService {

/*	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getDrinks", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Drink>> resolveCallPostOld(HttpSession session) {
  	
		
		List<Drink> drinks = new ArrayList<>();
		drinks.add(new Drink(1,"Honey","Cerveza honey",100,80,95,100));
		drinks.add(new Drink(2,"Ipa","Cerveza Ipa",100,60,100,100));
		drinks.add(new Drink(3,"Black","Cerveza Black",100,87,100,100));
		drinks.add(new Drink(4,"Pilsen","Cerveza Pilsen",90,13,105,100));
		drinks.add(new Drink(5,"Red","Cerveza red",90,55,100,100));
		drinks.add(new Drink(6,"Red Honey","Cerveza red honey",80,30,95,100));
		drinks.add(new Drink(7,"Black Honey","Cerveza black honey",90,63,95,100));

		List<JSONObject> entities = new ArrayList<JSONObject>();
		JSONObject entity;
		
		for (Drink d:drinks) {
			entity = new JSONObject();
            try {
				entity.put("id", d.getId());
				entity.put("name", d.getName());
				entity.put("description", d.getDescription());
				entity.put("soldLiters", d.getSoldLiters());
				entity.put("stockLiters", d.getStockLiters());
				entity.put("actualPrice", d.getActualPrice());
				entity.put("referencePrice",d.getReferencePrice());

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            entities.add(entity);
			
		}
		
        return new ResponseEntity<List<Drink>>(drinks, HttpStatus.OK);
    }
*/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getDrinks", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<DrinkToShow>> resolveCallPost(HttpSession session) {
  	
		
		List<Drink> drinks = new ArrayList<>();
		drinks.add(new Drink(1,"Honey","Cerveza honey",100,80,95,100));
		drinks.add(new Drink(2,"Ipa","Cerveza Ipa",100,60,100,100));
		drinks.add(new Drink(3,"Black","Cerveza Black",100,87,100,100));
		drinks.add(new Drink(4,"Pilsen","Cerveza Pilsen",90,13,105,100));
		drinks.add(new Drink(5,"Red","Cerveza red",90,55,100,100));
		drinks.add(new Drink(6,"Red Honey","Cerveza red honey",80,30,95,100));
		drinks.add(new Drink(7,"Black Honey","Cerveza black honey",90,63,95,100));


		List<DrinkToShow> drinkToShow = CalculatePricesHelper.calculateNewPrices(drinks);
		
        return new ResponseEntity<List<DrinkToShow>>(drinkToShow, HttpStatus.OK);
    }

	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/updatePrices", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Drink>> resolveCallUpdatePost(HttpSession session) {
  	
		
		List<Drink> drinks = new ArrayList<>();
		drinks.add(new Drink(1,"Honey","Cerveza honey",100,90,95,100));

		List<JSONObject> entities = new ArrayList<JSONObject>();
		JSONObject entity;
		
		for (Drink d:drinks) {
			entity = new JSONObject();
            try {
				entity.put("id", d.getId());
				entity.put("name", d.getName());
				entity.put("description", d.getDescription());
				entity.put("soldLiters", d.getSoldLiters());
				entity.put("stockLiters", d.getStockLiters());
				entity.put("actualPrice", d.getActualPrice());
				entity.put("referencePrice",d.getReferencePrice());

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            entities.add(entity);
			
		}
		
		System.out.println("Actualizo****");
		
        return new ResponseEntity<List<Drink>>(drinks, HttpStatus.OK);
    }
	
	
/*	 @GetMapping(path = "/hello", produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> sayHello()
	    {
	        
	        for (Entity n : entityList) {
	            JSONObject entity = new JSONObject();
	            entity.put("aa", "bb");
	            entities.add(entity);
	        }
	        return new ResponseEntity<Object>(entities, HttpStatus.OK);
 */   
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getDrinksAndUpdate", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<DrinkToShow>> getDrinksAndUpdate(HttpSession session) {
  	
		List<DrinkToShow> drinkToShow = MakeMagic.calculateNewPriceAndUpdate();
		
        return new ResponseEntity<List<DrinkToShow>>(drinkToShow, HttpStatus.OK);
    }

	
}
