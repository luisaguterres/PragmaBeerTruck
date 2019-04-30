package com.beer.truck.domain.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.beer.truck.domain.business.BeerBusiness;
import com.beer.truck.domain.entity.Beer;

@Named
@ViewScoped
public class BeerMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Beer beer = new Beer();	
	List<Beer> beers = new ArrayList<Beer>();
	
	BeerBusiness beerBusines = new BeerBusiness();	
	
	public void loadBeersList() {		
		if(beers.size() == 0) {
			beers = listBeers();			
		}		
	}
	
	private List<Beer> listBeers(){
		beers = beerBusines.listBeers();
		return beers;
	}
	
	public Beer search(Beer beer) {		
		return beerBusines.search(beer);
	}
	
	public Beer searchBeerByName(String beerName) {
		Beer beer =  beerBusines.searchBeerByName(beerName);
		return beer;
	}
		
	public List<Beer> getBeers() {
		return beers;
	}	
}
