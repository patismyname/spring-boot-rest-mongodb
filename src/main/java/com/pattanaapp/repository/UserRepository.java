package com.pattanaapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattanaapp.model.User;


/**
 * @author Bhupesh Singh Padiyar
 *
 */

public interface UserRepository extends MongoRepository<User, Long> {

	public User findById(String id);
	public Long deleteById(String id);
}
