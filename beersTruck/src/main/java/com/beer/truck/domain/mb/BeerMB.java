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
			beers.forEach(beer -> System.out.println(beer.getTempActual()));
		}		
	}
	
	public List<Beer> listBeers(){
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
	
	public void newBeer() {
		beerBusines.save(beer);
		loadBeersList();
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The Beer was saved Successfully", null));
	}
	
	public void removeContainer() {
		beerBusines.remove(beer);
		loadBeersList();
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The Beer was successful removed!", null));
	}

	
	public List<Beer> getBeers() {
		return beers;
	}
	
	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}

	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}
}
