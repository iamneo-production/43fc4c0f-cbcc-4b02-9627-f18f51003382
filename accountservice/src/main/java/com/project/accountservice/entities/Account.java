package com.project.accountservice.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	@Column(name="ACCOUNTNO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNo;
	
	private long accountBalance;
	
	private String date;
	
	private String branchCode;
	
	private String accType;
	
	private long customerId;
}
