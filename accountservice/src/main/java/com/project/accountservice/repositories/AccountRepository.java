package com.project.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.accountservice.entities.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public Account getByCustomerId(long customerId);

}
