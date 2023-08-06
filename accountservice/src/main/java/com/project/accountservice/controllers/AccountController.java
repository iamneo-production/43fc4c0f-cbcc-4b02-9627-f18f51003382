package com.project.accountservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountservice.entities.Account;
import com.project.accountservice.external.Authenticate;
import com.project.accountservice.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
		
	@Autowired
	private AccountService service;
	
	@Autowired
	Authenticate authenticate;
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addAccount(account));
	}
	
	
	@GetMapping("/{custId}/balance")
	public ResponseEntity<String> getBalanceByCustId(@PathVariable long custId){
		
		Account acc = service.getAccByCustomer(custId);
		
		Customer customer = authenticate.getCustomer((int)custId);
		String token = authenticate.login(customer.getName(), customer.getPassword());
		if (token != null){
		long balance = acc.getAccountBalance();
		
		return ResponseEntity.status(HttpStatus.OK).body("Your account balance is: "+ balance);
		}else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bad Credential.");
		}
		
	}
}
