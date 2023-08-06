package com.project.authenticate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int id;
	
	private String name;
	
	private String email;
	
	private String address;
	
	private String phoneNo;
	
	private String password;
}
