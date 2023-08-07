package com.example.demo.customer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.customer.entity.customer;
import com.example.demo.customer.service.custService;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController 
{
	@Autowired
    private custService service;
	
	
	
	@GetMapping("/")
public String home(Model m)	
{
	List<customer> cust=service.getAllCust();
	m.addAttribute("cust", cust);
		
	return "index";
}
	@GetMapping("/add_cust")
	public String add_customer()
	{
		return "add_cust";
	}
	
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute customer e,HttpSession session)
	{
	    System.out.println(e);
	    
	    service.addCust(e);
	    session.setAttribute("msg","Customer Added Sucessfully..");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		customer e=service.getEmpById(id);
		
		m.addAttribute("cust",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute customer e,HttpSession session)
	{
		service.addCust(e);
		session.setAttribute("msg","emp Data Update Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg", "Emp Data Delete Successfully");
		return "redirect:/";
	}
	
}
