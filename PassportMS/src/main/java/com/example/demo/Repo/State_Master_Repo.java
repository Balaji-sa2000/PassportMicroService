package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.State_Master;

public interface State_Master_Repo extends JpaRepository<State_Master,String>{
	
	
	//@Query("SELECT s FROM State_Master s WHERE s.state_Name=:state_Name")@Param("state_Name")@Param("stateName")
	State_Master findByStateName(String stateName);
	//@Query("SELECT s FROM State_Master s WHERE s.State_Name=:state")
	//State_Master findByState_Name(@Param("state") String state);



}
