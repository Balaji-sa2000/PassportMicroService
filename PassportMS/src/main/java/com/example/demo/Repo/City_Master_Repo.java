package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.City_Master;



public interface City_Master_Repo extends JpaRepository<City_Master,String> {
	//City_Master findByCity(String city);

	//City_Master findByCity(String state);
	//@Query("SELECT s FROM City_Master s WHERE s.City_Master=:city")
	//List<City_Master> findByCity(@Param("city") String city);

}
