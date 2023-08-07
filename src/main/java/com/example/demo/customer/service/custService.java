package com.example.demo.customer.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.entity.customer;
import com.example.demo.customer.repository.custRepo;


@Service
public class custService {

	@Autowired
	private custRepo custrepo;
	
	
	public void addCust(customer e)
	{
	
		custrepo.save(e);
	}
	
	public List<customer> getAllCust()
	{
		return custrepo.findAll();
	}
	
	public customer getEmpById(int id)
	{
		
		Optional<customer> e=custrepo.findById(id);
	if(e.isPresent())
	{
		return e.get();
	}
		return null;
	}
	
	public void deleteEmp(int id)
	{
		custrepo.deleteById(id);
	}
}
