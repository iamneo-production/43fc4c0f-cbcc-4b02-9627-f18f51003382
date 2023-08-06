package com.project.authenticate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.authenticate.entities.Customer;
import com.project.authenticate.external.CustomerIntf;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {
	
	@Autowired
	CustomerIntf customer;
	
	@GetMapping("/{custId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int custId){
		System.out.println("Hey");
		ResponseEntity<Customer> cust = customer.getCustomer(custId);
		return cust;
		
	}

}
