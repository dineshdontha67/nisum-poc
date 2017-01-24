package com.nisum.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nisum.domain.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{

	//fetching users by username
	//@Query("select u from User u where u.username like ?1")
	List<User> findByUsername(String username);
	
	//fetches users by country
	@Query("select u from User u where u.country = ?1")
	List<User> findByCountry(String country);
	
}
