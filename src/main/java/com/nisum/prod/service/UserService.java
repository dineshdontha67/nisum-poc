package com.nisum.prod.service;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.nisum.prod.domain.User;

@Profile("prod")
public interface UserService {

	public void saveOrUpdateUser(User user);
	
	public User getUser(String _id);
	
	public List<User> getUsers();
	
}
