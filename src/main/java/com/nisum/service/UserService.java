package com.nisum.service;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.nisum.domain.User;


@Profile("default")
public interface UserService {

	public void saveOrUpdateUser(User user);
	
	public User getUser(Integer userId);
	
	public List<User> getUserByName(String username);
	
	public List<User> getUsers();
	
}
