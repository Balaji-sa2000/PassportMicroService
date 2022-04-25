package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="City_Master")
public class City_Master {
	@Id
	private String city;
	@ManyToOne
	@JoinColumn(name="stateId")
	private State_Master  state_Master;
	
	
	public City_Master() {
		super();
	}


	public City_Master(String city, State_Master state_Master) {
		super();
		this.city = city;
		this.state_Master = state_Master;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public State_Master getState_Master() {
		return state_Master;
	}


	public void setState_Master(State_Master state_Master) {
		this.state_Master = state_Master;
	}


	@Override
	public String toString() {
		return "City_Master [city=" + city + ", state_Master=" + state_Master + "]";
	}
	
	
}

