package com.nisum.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.custom.exceptions.NoUserFoundException;
import com.nisum.custom.exceptions.ZeroUsersException;
import com.nisum.domain.User;
import com.nisum.service.UserService;


@Profile("default")
@Controller
public class UserController {
	
	@Autowired	
	UserService userService;
	/*@RequestMapping("/user")
	public User saveUser(){
		User user = new User("dinesh","ddontha@nisum.com","India",506002);
		userService.saveUser(user);
		return user;
	}*/
	
	private static final Logger logger 
		= LogManager.getLogger(UserController.class);
	
	@RequestMapping(value = "/user",method=RequestMethod.POST,
			consumes = "application/json")
	@ResponseBody
	public User userSave(@RequestBody User user){
		userService.saveOrUpdateUser(user);
		return user; //can also redirect to saved user user/userId.
	}
	
	@RequestMapping(value ="/user", method=RequestMethod.PUT,
			consumes = {MediaType.APPLICATION_JSON_VALUE})	
	@ResponseBody
	public User userUpdate(@RequestBody User user){
		userService.saveOrUpdateUser(user);
		return user; 
	}
	
	@RequestMapping("/user/{userId:[0-9]+}")
	@ResponseBody
	public User getUser(@PathVariable Integer userId){
		User user = userService.getUser(userId);
		
		if(user == null)
			throw new NoUserFoundException();
		
		return user;
	}
	
	@RequestMapping("/user/{username:[A-Za-z]+}")
	@ResponseBody
	public List<User> getUserByName(@PathVariable String username){
		logger.info("Entered into getUserByName");
		List<User> users = userService.getUserByName("%"+username+"%");
		
		if(users.size() == 0)
			throw new ZeroUsersException();
			
		return users;
	}
	
	@RequestMapping("/users")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
}
