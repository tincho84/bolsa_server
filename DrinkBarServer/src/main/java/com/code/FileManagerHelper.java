package com.code;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.code.drink.Beer;

public class FileManagerHelper {

	
	private static final String beersFile = "beers.txt";
	
	public boolean saveRegisterToFileSystem(){
		return true;
	}
	
	
	/**
	 * Lee todas las cervezas disponibles con sus caracteristicas
	 */
	public List<Beer> readAllBeers() {
		
		List<Beer> beer = new ArrayList<Beer>();
		
		try {
			beer = Files.lines(Paths.get( ClassLoader.getSystemResource(beersFile).toURI()))
			        .map(mapLineToBeer)
			        .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return beer;
		
	}
	
	Function<String, Beer> mapLineToBeer = new Function<String, Beer>() {

	    public Beer apply(String line) {

	        Beer beer = new Beer();

	        String[] beerPieces = line.split("\\|");

	        beer.setId(beerPieces[0]); 
	        beer.setName(beerPieces[1]);
	        beer.setDescription(beerPieces[2]);
	        beer.setIbu(beerPieces[3]);
	        beer.setAlcohol(beerPieces[4]);
	        
	        return beer;
	    }
	};
	
	
	
	public static void main(String[] args) {
		FileManagerHelper f = new FileManagerHelper();
		List<Beer> l = f.readAllBeers();
		System.out.println("Chau");
	}
}
