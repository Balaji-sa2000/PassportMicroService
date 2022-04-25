package com.example.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Passport {
	
	@Id
	@NotNull
	private String temporaryNo;
	@NotNull(message="error code 613")
	private String country;
	@NotNull(message="error code 614")
	private String state;
	@NotNull(message="error code 615")
	private String city;
	@NotNull(message="error code 616")
	private int pin;
	@NotNull(message="error code 617")
	private String applicationType;
	@NotNull(message="error code 618")
	private String bookletType;
	//@NotBlank(message="error code 619")
	LocalDate dateOfIssue;
	LocalDate dateOfExpiry;
	@OneToOne
	@JoinColumn(name="userId",referencedColumnName="userId")
	private Users users;
	public Passport() {
		super();
	}
	public Passport(@NotNull String temporaryNo, @NotNull(message = "error code 613") String country,
			@NotNull(message = "error code 614") String state, @NotNull(message = "error code 615") String city,
			@NotNull(message = "error code 616") int pin, @NotNull(message = "error code 617") String applicationType,
			@NotNull(message = "error code 618") String bookletType, LocalDate dateOfIssue, LocalDate dateOfExpiry,
			Users users) {
		super();
		this.temporaryNo = temporaryNo;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.applicationType = applicationType;
		this.bookletType = bookletType;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.users = users;
	}
	public String getTemporaryNo() {
		return temporaryNo;
	}
	public void setTemporaryNo(String temporaryNo) {
		this.temporaryNo = temporaryNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getBookletType() {
		return bookletType;
	}
	public void setBookletType(String bookletType) {
		this.bookletType = bookletType;
	}
	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Passport [temporaryNo=" + temporaryNo + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", pin=" + pin + ", applicationType=" + applicationType + ", bookletType=" + bookletType
				+ ", dateOfIssue=" + dateOfIssue + ", dateOfExpiry=" + dateOfExpiry + ", users=" + users + "]";
	}
}