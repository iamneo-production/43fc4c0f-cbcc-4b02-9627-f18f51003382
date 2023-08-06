package com.project.accountservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountservice.entities.Account;
import com.project.accountservice.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accRepository;
	
	public Account addAccount(Account account) {
		return accRepository.save(account);
	}
	
	public Account getAccount(long id){
		return accRepository.findById(id).get();
	}
	
	public List<Account> getAllAccounts(){
		return accRepository.findAll();
	}
	
	public Account getAccByCustomer(long customerId) {
		return accRepository.getByCustomerId(customerId);
	}
	
}
