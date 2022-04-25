package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Users;
public interface User_Repo extends JpaRepository<Users,String>{
	//@Query("SELECT p FROM User_Registration p WHERE p.userId=:id")
	//Optional<User_Registration> findByUserId(@Param("id") String userId);
	//@Query("SELECT p FROM User_Registration p WHERE p.user_Id=:user_Id")
	//Optional<User_Registration> findByUserId(@Param("user_Id") String user_Id);
}
