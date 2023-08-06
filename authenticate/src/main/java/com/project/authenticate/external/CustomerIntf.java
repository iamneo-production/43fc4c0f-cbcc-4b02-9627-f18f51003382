package com.project.authenticate.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.authenticate.entities.Customer;


@FeignClient(name = "Customer-Service")
public interface CustomerIntf {
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId);
	
}
