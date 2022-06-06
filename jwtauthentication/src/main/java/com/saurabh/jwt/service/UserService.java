package com.saurabh.jwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saurabh.jwt.entities.User;
import com.saurabh.jwt.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> temp = ur.findById(username);
		User user = null;
		if(temp.isPresent()) {
			user = temp.get();
		}
		return (UserDetails) user;
	}

}
