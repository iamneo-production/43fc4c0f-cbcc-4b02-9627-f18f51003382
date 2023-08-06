package com.project.accountservice.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.accountservice.dto;
import com.project.accountservice.entities.Customer;


@FeignClient(name="Authenticate-Service")
public interface Authenticate {
	
	@GetMapping("/authenticate/{custId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int custId);

	@PostMapping("/authenticate/login")
	public String login(@RequestBody LoginRequestDTO loginReqDto);
}
