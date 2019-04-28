package com.beer.truck.domain.entity;

import java.io.Serializable;

public class Beer implements Serializable{
	
	private static final long serialVersionUID = 5588192496905496375L;

	private int id;

	private String name;
	
	private Double tempMinimum;
	
	private Double tempMaximum;
	
	private Double tempActual;
	
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public Double getTempMinimum() {
		return tempMinimum;
	}
	public void setTempMinimum(Double tempMinimum) {
		this.tempMinimum = tempMinimum;
	}
	
	public Double getTempMaximum() {
		return tempMaximum;
	}
	public void setTempMaximum(Double tempMaximum) {
		this.tempMaximum = tempMaximum;
	}
	public Double getTempActual() {
		if(tempActual == null) {
			tempActual = tempMinimum;
		}
		return tempActual;
	}
	public void setTempActual(Double tempActual) {
		this.tempActual = tempActual;
	}
	
	public String getStatus() {
		if(status == null) {
			status = "Stable";
		}
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
