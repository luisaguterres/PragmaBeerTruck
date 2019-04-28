package com.beer.truck.domain.entity;

import java.io.Serializable;


public class Container implements Serializable{
		
	private static final long serialVersionUID = 5588192496905496375L;
	
	private int id;
		
	private Beer beer;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Beer getBeer() {
		return beer;
	}
	public void setBeer(Beer beer) {
		this.beer = beer;
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
		Container other = (Container) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
