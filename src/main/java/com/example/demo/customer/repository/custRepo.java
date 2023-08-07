package com.example.demo.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.customer.entity.customer;

@Repository
public interface custRepo extends JpaRepository<customer,Integer>{

	customer findByEmail(String email);
	
}