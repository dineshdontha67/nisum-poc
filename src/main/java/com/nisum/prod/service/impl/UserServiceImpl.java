package com.nisum.prod.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.nisum.mongo.repository.impl.UserCustomRepository;
import com.nisum.prod.domain.User;
import com.nisum.prod.service.UserService;

/**
 * @author Dinesh Dontha
 * 
 * We can maintain different service implementations for different
 * profiles
 *
 */
@Profile("prod")
@Service
public class UserServiceImpl implements UserService{

/*	@Autowired
	UserRepository userRepository;*/
	
	@Autowired
	UserCustomRepository userCustomRepository;
	
	public void saveOrUpdateUser(User user) {
		//userRepository.save(user);
		userCustomRepository.saveOrUpdateUser(user);
	}

	public User getUser(String _id) {
		//ObjectId objectId = new ObjectId(_id);
		User user = userCustomRepository.getUser(_id); //findOne(userId);		
		return user;
	}

	public List<User> getUsers() {
		//return (List<User>) userRepository.findAll();
		return null;
	}

}
