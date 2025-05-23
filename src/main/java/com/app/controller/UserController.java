package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		System.out.println("Hello");
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return userService.verifyUser(user);
	}
}
