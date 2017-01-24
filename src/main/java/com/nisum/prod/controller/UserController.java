package com.nisum.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.prod.domain.User;
import com.nisum.prod.service.UserService;





@Profile("prod")
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
	
	@RequestMapping("/user/{_id}")
	public String getUser(@PathVariable String _id){
		User user = userService.getUser(_id);
		return user.getUsername();
	}
	
	@RequestMapping("/users")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
}
