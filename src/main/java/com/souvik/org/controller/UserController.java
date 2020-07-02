package com.souvik.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.souvik.org.model.User;
import com.souvik.org.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRep;

	@PostMapping("/placeItem")
	public String placeOrder(@RequestBody User user) {
		userRep.save(user);
		return "Order Placed Successfully";
	}
	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return userRep.findByName(name);
	}
	
	@GetMapping("/getUserByCity/{city}")
	public List<User> getUserByCity(@PathVariable String city) {
		return userRep.findByCity(city);
	}
	
	@GetMapping("/getUserByProduct/{productName}")
	public List<User> getUserByProduct(@PathVariable String productName) {
		return userRep.findByProductsName(productName);
	}
}
