	package com.nisum.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@NamedQuery(name = "User.findByUsername", 
	query = "select u from User u where u.username like ?1")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	Integer userId;
	
	@Column(name="USERNAME")
	String username;
	
	@Column(name="PASSWORD")
	String password;
	
	@Column(name="EMAIL")
	String mail;
	
	@Column(name="COUNTRY")
	String country;
	
	@Column(name="PIN_CODE")
	Integer pincode;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="user")
	Set<UserRoles> roles;
	
	public User() {
	}	

	public User(String username, String password, String mail, String country, Integer pincode) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.country = country;
		this.pincode = pincode;
	}

	public User(Integer userId, String username, String password, String mail, String country, Integer pincode) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.country = country;
		this.pincode = pincode;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "[ "+userId+username+" "+mail+" "+pincode+" ]";
	}

	
}
