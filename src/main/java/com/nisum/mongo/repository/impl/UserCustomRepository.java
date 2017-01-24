package com.nisum.mongo.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nisum.prod.domain.User;

@Profile("prod")
@Repository
public class UserCustomRepository implements com.nisum.mongo.repository.Repository<User> {

	@Autowired 
	MongoTemplate mongoTemplate;

	public User getUser(String _id) {
		Criteria criteria = Criteria.where("_id").is(_id);
		Query query = new Query(criteria);
		return (User) mongoTemplate.find(query, User.class);
	}

	public void saveOrUpdateUser(User user) {
		mongoTemplate.save(user);
	}
	
}
