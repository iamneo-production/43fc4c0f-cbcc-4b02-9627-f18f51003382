package com.project.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Customer findByName(String name);
}
