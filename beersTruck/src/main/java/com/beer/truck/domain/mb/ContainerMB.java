package com.beer.truck.domain.mb;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
			containers = contBusiness.listContainers();		
		}		
	}
			
	public Container searchContainerById(Integer idContainer){		
		return containers.stream().filter(c -> c.getId() == idContainer).findFirst().get();
	}
	
	public void openTruckDoors() {		
		Double tempIncrease = 0.2;
						
		containers.forEach(cont -> cont.getBeer().setTempActual(measuredTemperature(cont, tempIncrease)));		
		containers.forEach(cont -> cont.getBeer().setStatus(updateContainerStatus(cont)));
		
	}

	public String updateContainerStatus(Container container) {
		
		Double min = container.getBeer().getTempMinimum();
		Double max = container.getBeer().getTempMaximum();
		Double measured = container.getBeer().getTempActual();
		
		Double difference = max - min; 
		
		if(measured < (min + difference * 0.60)){			
   			return "Stable";   			
        }else if (measured < (min + difference * 0.80)){
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "The temperature of "+container.getBeer().getName()+" container is getting too high."));
        	return "Alert";        	
        }else{
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "The temperature of "+container.getBeer().getName()+" is dangerously high!"));
        	return "Danger";        	
        }
	}

	public Double measuredTemperature(Container container, double tempIncrease) {		
		return container.getBeer().getTempActual() + tempIncrease;
	}

	public List<Container> getContainers() {
		return containers;
	}
	
}
