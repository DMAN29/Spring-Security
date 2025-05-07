package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BasicController {

	
	@GetMapping("")
	public String helloController(HttpServletRequest request) {
		return "Hello there Seccion ID : "+ request.getSession().getId();
	}
}
