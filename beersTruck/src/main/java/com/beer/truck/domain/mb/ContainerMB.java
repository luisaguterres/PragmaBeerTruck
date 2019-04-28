package com.beer.truck.domain.mb;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.beer.truck.domain.business.ContainerBusiness;
import com.beer.truck.domain.entity.Container;

@Named
@ViewScoped
public class ContainerMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static DecimalFormat decimalFormat = new DecimalFormat("###.##");
	
	List<Container> containers = new ArrayList<Container>();
	private Container container = new Container();
	
	BeerMB beerMB = new BeerMB();
	ContainerBusiness contBusiness = new ContainerBusiness();
	
	public void loadContainersList(){		
		if(containers.size() == 0) {
			containers = contBusiness.getContainersList();		
		}		
	}
			
	public Container searchContainerById(Integer idContainer){		
		Container container = containers.stream().filter(c -> c.getId() == idContainer).findFirst().get();
		return container;
	}
	
	public void newContainer() {
		contBusiness.save(container);
		
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "A new Container was loaded at the Truck!", null));
	}
	
	public void removeContainer() {
		contBusiness.remove(container);
		
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The Container was successful removed!", null));
	}
	
	public void openTruckDoors() {		
		Double tempIncrease = 0.2;
						
		containers.forEach(cont -> cont.getBeer().setTempActual(measuredTemperature(cont, tempIncrease)));		
		containers.forEach(cont -> cont.getBeer().setStatus(updateContainerStatus(cont.getBeer().getTempActual(), cont.getBeer().getTempMinimum(), cont.getBeer().getTempMaximum())));
		
	}

	private String updateContainerStatus(Double measured, Double min, Double max) {
		
		Double difference = max - min;
		
		if(measured < (min + difference * 0.60)){
   			return "Stable";
   			//beer_status.style.backgroundColor = "#99ff99";
        }else if (measured < (min + difference * 0.80)){
        	return "Alert";
        	//beer_status.style.backgroundColor = "#ffff66";
        }else{
        	return "Danger";
        	//beer_status.style.backgroundColor = "#ff9999";
        }
	}

	public Double measuredTemperature(Container container, double tempIncrease) {		
		return container.getBeer().getTempActual() + tempIncrease;
	}

	public List<Container> getContainers() {
		return containers;
	}
	
}
