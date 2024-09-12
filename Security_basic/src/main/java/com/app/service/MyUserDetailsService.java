package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.model.UserPrincipal;
import com.app.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByName(username);
		
		if(user == null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("User not Found with username"+ username);
		}
		
		
		return new UserPrincipal(user);
	}

}
