package com.nisum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.nisum.domain.User;
import com.nisum.jpa.repository.UserJpaRepository;
import com.nisum.repository.UserRepository;
import com.nisum.service.UserService;

@Profile("default")
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	public void saveOrUpdateUser(User user) {
		userRepository.save(user);
	}

	public User getUser(Integer userId) {
		User user = userRepository.findOne(userId);
		return user;
	}

	public List<User> getUserByName(String username) {
		return userJpaRepository.findByUsername(username);
	}

	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

}
