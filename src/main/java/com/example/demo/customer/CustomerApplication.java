package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner
{
	private  PasswordEncoder passwordEncoder;

	
	

	    

	    @Autowired
	    public CustomerApplication(PasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }

	    

	public static void main(String[] args) 
	{
		SpringApplication.run(CustomerApplication.class, args);
	}
     
	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println(this.passwordEncoder.encode("Prakhar"));
		
	}

}
