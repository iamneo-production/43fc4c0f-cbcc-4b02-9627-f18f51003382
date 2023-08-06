package com.project.customerservice.service;

import java.util.List;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.customerservice.entities.Customer;
import com.project.customerservice.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer saveUser(Customer customer) {
		// TODO Auto-generated method stub
		//String randomUserId = UUID.randomUUID().toString();
		//customer.setId(randomUserId);
		return repository.save(customer);
	}
	
	public Customer getCustomer(int userId) {
		// TODO Auto-generated method stub
		
		return repository.findById(userId).get();
	}
	
	public List<Customer> getAllCustomers(){
		return repository.findAll();
	}

	public Customer findByName(String name){
		return repository.findByName(name);
	}
}