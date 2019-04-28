package com.beer.truck.domain.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.beer.truck.domain.entity.Container;


public class ContainerBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BeerBusiness beerBusiness = new BeerBusiness();
	
	private List<Container> containersList = new ArrayList<Container>(); 
			
	public void save(Container container){
		this.containersList.add(container);
	}
		
	public void remove(Container container){
		this.containersList.remove(container);
	}
	
	public Container search(Container container){
		return this.containersList.get(container.getId());
	}

	public List<Container> getContainersList() {
		
		if (this.containersList.size() == 0) {
			
			beerBusiness.loadBeers();
						
			Container contPale = new Container();
			contPale.setId(1);
			contPale.setBeer(beerBusiness.searchBeerByName("Pale Ale"));
			
			Container contIpa = new Container();
			contIpa.setId(2);
			contIpa.setBeer(beerBusiness.searchBeerByName("IPA"));
			
			Container contLager = new Container();
			contLager.setId(3);
			contLager.setBeer(beerBusiness.searchBeerByName("Lager"));
			
			Container contStout = new Container();
			contStout.setId(4);
			contStout.setBeer(beerBusiness.searchBeerByName("Stout"));
			
			Container contWheatbeer = new Container();
			contWheatbeer.setId(4);
			contWheatbeer.setBeer(beerBusiness.searchBeerByName("Wheat beer"));
			
			Container contPilsner = new Container();
			contPilsner.setId(4);
			contPilsner.setBeer(beerBusiness.searchBeerByName("Pilsner"));
						
			containersList.add(contPale);
			containersList.add(contIpa);
			containersList.add(contLager);
			containersList.add(contStout);
			containersList.add(contWheatbeer);
			containersList.add(contPilsner);
									
		}
		return containersList;
	}

	public void setContainersList(List<Container> containersList) {
		this.containersList = containersList;
	}
	
}
