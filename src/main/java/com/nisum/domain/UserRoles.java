package com.nisum.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dineshdontha
 * 
 * This entity keeps track all the users & their associated roles.
 *
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="USER_ROLE_ID")
	Integer userRoleId;
	
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	Role role;
	

	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	User user;

	
	@Column(name="USERNAME")
	String username;
	
	@Column(name="ROLE_NAME")
	String roleName;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
