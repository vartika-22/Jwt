package com.example.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password) {
		if(userName.equals("admin") && password.equals("admin123")) {
			return jwtService.generateToken(userName);
		}else {
			return "Invalid Username or password";
		}
	}

}
