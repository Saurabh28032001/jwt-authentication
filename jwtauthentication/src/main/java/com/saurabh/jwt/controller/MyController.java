package com.saurabh.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.jwt.entities.AuthRequest;
import com.saurabh.jwt.entities.Response;
import com.saurabh.jwt.service.UserService;
import com.saurabh.jwt.util.JwtUtil;

@RestController
public class MyController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String home() {
		return "Hi, This is our home page";
	}
	
	@GetMapping("/about")
	public String about() {
		return "Hi, This is our about page";
	}
	
	@PostMapping("/login")
	public Response validateLogin(@RequestBody AuthRequest authRequest) {
		UserDetails user = us.loadUserByUsername(authRequest.getUsername());
		Response response = new Response();
		response.setJwt(null);
		
		if(user.getPassword().equals(authRequest.getPassword())) {
			String token = jwtUtil.generateToken(authRequest.getUsername());
			response.setJwt(token);
		}
		return response;
	}
}
