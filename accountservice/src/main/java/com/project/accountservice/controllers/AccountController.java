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
	@CircuitBreaker(name="accountService",fallbackMethod = "alternate")
	public ResponseEntity<String> getBalanceByCustId(@PathVariable long custId){
		
		Account acc = service.getAccByCustomer(custId);
		
		Customer customer = authenticate.getCustomer((int)custId);
		String token = authenticate.login(customer.getName(), customer.getPassword());
		if (token != null){
		long balance = acc.getAccountBalance();
		authenticate.getCustomer((int)custId);
			
			AuditLogs audit = new AuditLogs();
			audit.setCustomerId(custId);
			audit.setStatus(true);
			
			auditIntf.addAuditLog(audit);
			//return notifications.addNotice(true) ;
			return ResponseEntity.status(HttpStatus.OK).body(notifications.addNotice(true) + balance);
		}else{
			AuditLogs audit = new AuditLogs();
			audit.setCustomerId(custId);
			audit.setStatus(false);
			
			auditIntf.addAuditLog(audit);
			//return notifications.addNotice(false);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notifications.addNotice(false));
		}
		
		
	}

	public String alternate(@PathVariable long custId) {
		return "The service down!";
	}
}
