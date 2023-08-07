package com.example.demo.customer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.customer.entity.customer;
import com.example.demo.customer.repository.custRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private custRepo custrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		
		customer customer=this.custrepo.findByEmail(username);
		
		
		return customer;
	}

	
}
