package com.training.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.bean.User;
import com.training.userservice.configuration.Configuration;

@RestController
public class UserController {
	
	

		@Autowired
		private Configuration configuration;

		@GetMapping("/users")
		public User retrieveUser() {
						//return new User("HarCoded Name","HardCoded Location");
						
						 return new User(configuration.getUsername(), configuration.getLocation());
						 
		}


}
