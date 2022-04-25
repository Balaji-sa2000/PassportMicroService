package com.example.demo.Service;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.City_Master;
import com.example.demo.Model.Passport;
import com.example.demo.Model.Passport_Register;
import com.example.demo.Model.State_Master;
import com.example.demo.Model.Users;
import com.example.demo.Repo.City_Master_Repo;
import com.example.demo.Repo.Passport_Repo;
import com.example.demo.Repo.State_Master_Repo;
import com.example.demo.Repo.User_Repo;

@Service
public class Passport_Service {
	@Autowired
	private User_Repo repo;
	@Autowired
	private State_Master_Repo stateRepo;
	@Autowired
	private City_Master_Repo cityRepo;
	@Autowired
	private Passport_Repo passportRepo;

	
	

	

	public String register(Passport_Register passportRegister) {
		LocalDate issueDate=passportRegister.getDate_Of_Issue();
		LocalDate expiryDate=issueDate.plusYears(10);
		long n=passportRepo.find(String.valueOf(passportRegister.getBooklet_Type().charAt(0))+String.valueOf(passportRegister.getBooklet_Type().charAt(1)));
		String temp=String.valueOf(n+1);
		if(temp.length()<4) {
			int k=temp.length();
			for(int i=0;i<4-k;i++)
				temp="0"+temp;
		}
		String s="FPS-"+passportRegister.getBooklet_Type().charAt(0)+passportRegister.getBooklet_Type().charAt(1)+temp;
		Passport registered= new Passport();
		registered.setApplicationType(passportRegister.getApplication_Type());
		registered.setTemporaryNo(s);
		registered.setCountry(passportRegister.getCountry());
		registered.setState(passportRegister.getStateName());
		registered.setCity(passportRegister.getCity());
		registered.setPin(passportRegister.getPin());
		registered.setBookletType(passportRegister.getBooklet_Type());
		registered.setDateOfIssue(passportRegister.getDate_Of_Issue());
		registered.setDateOfExpiry(expiryDate);
		
				//registered.toString();
		registered.setUsers(repo.findById(passportRegister.getUser_Id().toString()).get());  //repo.findById(passportRegister.getUser_Id()).get()
		passportRepo.save(registered);
		return  registered.toString();
		
		
	}



	public State_Master findByStateName(String stateName) {
		
		return stateRepo.findByStateName(stateName);
	}



	public City_Master findByCity(String city) {
		// TODO Auto-generated method stub
		return cityRepo.getById(city);
	}



	public Passport findByTemporaryNo(String temporaryNo) {
		
	return passportRepo.findById(temporaryNo).get();
	}



	/*public  Users havePassport(String user_Id) {
		return repo.findById(user_Id).get();
	}*/



	/*public Optional<Passport_Registration> getPassport(String userId) {
		return passportRepo.findByUserRegistration(userId);
	}*/	
	
}

