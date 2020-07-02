package com.souvik.org.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.souvik.org.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	List<User> findByName(String name);
	
	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);
	
	//@Query("{ 'products.name' : ?0 }") // this will also work
	List<User> findByProductsName(String productName);
	
	

}
