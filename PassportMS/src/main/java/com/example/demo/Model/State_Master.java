package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State_Master {
	private String stateName;
	@Id
	private String stateId;

	/*@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="State_Id")*/
	@OneToMany(mappedBy="state_Master")
	private List<City_Master> city_Master =new ArrayList<>();

	public State_Master() {
		super();
	}

	public State_Master(String stateName, String stateId) {
		super();
		this.stateName = stateName;
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public List<City_Master> getCity_Master() {
		return city_Master;
	}

	public void setCity_Master(List<City_Master> city_Master) {
		this.city_Master = city_Master;
		 for(City_Master b : city_Master) {
	            b.setState_Master(this);
	        }
	}

	@Override
	public String toString() {
		return "State_Master [stateName=" + stateName + ", stateId=" + stateId + "]";
	}
	

	

	
	
	
}
