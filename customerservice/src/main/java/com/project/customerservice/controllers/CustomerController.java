package com.project.customerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.customerservice.entities.Customer;
import com.project.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveUser(customer));
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
		Customer user = customerService.getCustomer(customerId);
		System.out.println(user);
		return ResponseEntity.ok(user);
	}
	 
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		System.out.print("Hey");
		List<Customer> cust = customerService.getAllCustomers();
		return ResponseEntity.ok(cust);
	}
	
}
