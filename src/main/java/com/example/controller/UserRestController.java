package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserRestController {

	private UserRepository userRepository;

	@Autowired
	public UserRestController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> readUsers() {
		System.out.println("why?" + userRepository);
		return userRepository.findAll();
	}
}
