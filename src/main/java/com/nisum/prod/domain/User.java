package com.nisum.prod.domain;

import javax.persistence.Id;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produser")
@Profile("prod")
public class User {

	@Id
	String _id;
	
	//@Column(name="USERNAME")
	String username;
	
	//@Column(name="EMAIL")
	String mail;
	
	//@Column(name="COUNTRY")
	String country;
	
	//@Column(name="PIN_CODE")
	Integer pincode;
	
	public User() {
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}	
	
}
