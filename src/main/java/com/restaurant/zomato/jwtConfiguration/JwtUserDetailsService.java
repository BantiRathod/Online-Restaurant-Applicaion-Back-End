/*package com.restaurant.zomato.jwtConfiguration;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restaurant.zomato.entities.Users;
import com.restaurant.zomato.services.UserService;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Autowired 
	private UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
	Users user = userService.getOneUser(Long.parseLong(username));
		//String pass = bcryptEncoder.encode(user.getPassword());
	
	//  logger.info("user received from database {}", person);
		
		if (user.getPhoneNumber()==Long.parseLong(username)) {
		
			return new User(String.valueOf(user.getPhoneNumber()), user.getPassword(),new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
	*/