package com.nisum.mongo.repository;

import com.nisum.prod.domain.User;

public interface Repository<T> {
	
	User getUser(String _id);
	
	void saveOrUpdateUser(User user);

}
