package com.example.demo.Controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.Registration_Exception;
import com.example.demo.Model.City_Master;
import com.example.demo.Model.Login;
import com.example.demo.Model.Passport;
import com.example.demo.Model.Passport_Register;
import com.example.demo.Model.State_Master;
import com.example.demo.Service.Passport_Service;


@RestController
@RequestMapping("/Register")
public class Passport_Controller {
	
	
	@Autowired
	private Passport_Service passportService;
	
	@GetMapping("/Home")
	public String home() {
		
		System.out.println("Home1");
		return "Home";
	}
	
	
	@GetMapping("/getById")                                                        
	public ResponseEntity<Passport> getById(@RequestBody Login login) {
		String temporaryNo=login.getTemp();
		Passport s=passportService.findByTemporaryNo(temporaryNo);
		return new ResponseEntity<Passport>(s,HttpStatus.OK);
	}

	
	@PutMapping("/Passport")
	public String Register(@RequestBody  Passport_Register passportRegister) throws Registration_Exception {
		String s="";
		int i=0;
			Passport register;
			s=String.valueOf(passportRegister.getPin());                                                                                                                              
			if(s.length()==6) {
				
				if(s.matches("[0-9]+")) {
					i=1;
				}
				
				else {
					throw new Registration_Exception("Invalid Pin");
					
				}
			}
               
			else
			{
				throw new Registration_Exception("Invalid Pin");
			}
			if(i==1) {
				City_Master city=passportService.findByCity(passportRegister.getCity());
				State_Master state=city.getState_Master();
			//	return city.toString()+" "+state.toString()+"  "+;
			    if(!state.getStateName().equals((passportRegister.getStateName()))) {
			    	throw new Registration_Exception("Invalid State City");
			    }
			    
			    else {
			    	i=2;
			    }
			}
			if(i==2) {
				LocalDate issuedDate=passportRegister.getDate_Of_Issue();
				LocalDate today=LocalDate.now();
				if(today.isBefore(issuedDate)) {
					i=3;
					//register=passportService.register(passportRegister);
					return passportService.register(passportRegister).toString();
				}
				
				else {
					throw new Registration_Exception("Invalid IssueDate");
				}
				
				
			}
			//System.out.println("Registered Successfully for Passport\n"+register.toString());
			return "Registered Successfully for Passport";
	
		
	}
}