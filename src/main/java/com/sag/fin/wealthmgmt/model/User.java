package com.sag.fin.wealthmgmt.model;

import java.io.Serializable;

public class User implements Serializable{
	private String firstName;
	private String lastName;
	private String Address;
	private String City;
	private String State;
	private String Country;
	private String Zip;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	public User(String firstName, String lastName, String address, String city, String state, String country,
			String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		City = city;
		State = state;
		Country = country;
		Zip = zip;
	}
	public User(){
		super();
	}
	
}
