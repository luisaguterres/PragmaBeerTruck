package com.beer.truck.domain.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.beer.truck.domain.entity.Beer;


public class BeerBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	List<Beer> beers = new ArrayList<Beer>();
		
	public void save(Beer beer){
		this.beers.add(beer);
	}
	
	public void remove(Beer beer){
		this.beers.remove(beer.getId());
	}
	
	public Beer search (Beer beer){
		return this.beers.get(beer.getId());
	}
	
	public Beer searchBeerByName (String beerName){	
		System.out.println("Beer business >> " + beers.size());
		return beers.stream().filter(b -> b.getName() == beerName).findFirst().get();
	}
	
	public void loadBeers() {
		if(beers.size() == 0) {
			setBeers(listBeers());
		}
	}
	
	public List<Beer> listBeers(){
				
			Beer pilsner = new Beer();
			pilsner.setId(1);
			pilsner.setName("Pilsner");
			pilsner.setTempMinimum(4.0);
			pilsner.setTempMaximum(6.0);
			
			Beer ipa = new Beer();
			ipa.setId(2);
			ipa.setName("IPA");
			ipa.setTempMinimum(5.0); 
			ipa.setTempMaximum(6.0);
			
			Beer lager = new Beer();
			lager.setId(3);
			lager.setName("Lager");
			lager.setTempMinimum(4.0);
			lager.setTempMaximum(7.0);
			
			Beer stout = new Beer();
			stout.setId(4);
			stout.setName("Stout");
			stout.setTempMinimum(6.0);
			stout.setTempMaximum(8.0);
			
			Beer wheat = new Beer();
			wheat.setId(5);
			wheat.setName("Wheat beer");
			wheat.setTempMinimum(3.0);
			wheat.setTempMaximum(5.0);
			
			Beer pale = new Beer();
			pale.setId(6);
			pale.setName("Pale Ale");
			pale.setTempMinimum(4.0);
			pale.setTempMaximum(6.0);
			
			this.beers.add(pilsner);
			this.beers.add(ipa);
			this.beers.add(lager);
			this.beers.add(stout);
			this.beers.add(wheat);
			this.beers.add(pale);		
				
		return beers;
	}

	public List<Beer> getBeers() {
		return beers;	
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}
	
}
