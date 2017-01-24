package com.nisum.repository;

import java.io.Serializable;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nisum.domain.User;

@Repository
@Profile("default")
public interface UserRepository extends CrudRepository<User, Serializable>{
	
	User findByUsername(String username);
}
