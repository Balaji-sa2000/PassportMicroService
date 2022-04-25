package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Passport;

public interface Passport_Repo extends JpaRepository<Passport,String>{
	
	   @Query("SELECT COUNT(p) FROM Passport p WHERE p.temporaryNo LIKE CONCAT('____',:type,'____')")
	   public long find(@Param("type") String type);

	//public Optional<Passport_Registration> findByUserId(String userId);
} 