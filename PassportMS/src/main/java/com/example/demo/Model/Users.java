package com.example.demo.Model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;


@Entity
public class Users {
	
	@Id
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@NotBlank(message="userId must not be blank")
	private String userId;
	
	@NotBlank(message="Name must not be blank")
	//@Pattern(regexp="[^A-Za-z]*$",message ="Name should be alphabets")
	private String name;
	
	@NotBlank(message="Password must not be blank")
	@Pattern(regexp="^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message="Password should of 8 characters and should contain #")
	private String password;
	
	@NotBlank(message="Qualification must not be blank")
	private String qualification;
	
	@NotBlank(message="EmailId must not be blank")
	//@Pattern(regexp="^[a-zA-Z0-9_!#$%&'+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&'+/=?`{|}~^-]+)@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)$",message="Email should be in correct format")
	private String emailId;
	
	@Range(min=1,message="Contact should not be blank")
	//@Pattern(regexp="(^$|[0-9])",message="Contact should be number")
	private long contact;
	
	private LocalDate dateOfBirth;
	
	@NotBlank(message="ApplyType must not be blank")
	private String applyType;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String citizenship;
	
	@NotBlank(message="Gender must be select")
	private String gender;
	
	@NotBlank(message="hintQuestion must not be blank")
	private String hintQuestion;
	
	@NotBlank(message="hintAnswer must not be blank")
	private String hintAnswer;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public @Range(min = 1, message = "Contact should not be blank") long getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHintQuestion() {
		return hintQuestion;
	}
	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}
	public String getHintAnswer() {
		return hintAnswer;
	}
	public void setHintAnswer(String hintAnswer) {
		this.hintAnswer = hintAnswer;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", password=" + password + ", qualification="
				+ qualification + ", emailId=" + emailId + ", contact=" + contact + ", dateOfBirth=" + dateOfBirth
				+ ", applyType=" + applyType + ", citizenship=" + citizenship + ", gender=" + gender + ", hintQuestion="
				+ hintQuestion + ", hintAnswer=" + hintAnswer + "]";
	}
	
}