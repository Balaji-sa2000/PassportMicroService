package com.example.demo.Model;


import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Passport_Register {
	@NotBlank(message="error code 613")
	private String country;
	@NotBlank(message="error code 614")
	private String stateName;
	@NotBlank(message="error code 615")
	private String city;
	@NotBlank(message="error code 616")
	private int pin;
	@NotBlank(message="error code 617")
	private String application_Type;
	@NotBlank(message="error code 618")
	private String booklet_Type;
	@NotBlank(message="error code 619")
	LocalDate date_Of_Issue;
	private String user_Id;
	
}

