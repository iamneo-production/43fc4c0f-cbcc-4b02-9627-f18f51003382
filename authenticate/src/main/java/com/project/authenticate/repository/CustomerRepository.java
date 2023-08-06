package com.project.authenticate.repository;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;

@Repository
public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public CustomerRepository(){
        customerList.add(new Customer(1, "Prakhar", "Prakaht@gmail.com", "Jabapur", "7643789", "Pssword"),
        new Customer(1, "Preeti", "Prakaht@gmail.com", "Jabapur", "7643789", "123"),
        new Customer(1, "Swati", "Prakaht@gmail.com", "Jabapur", "7643789", "456"));
    }


    public Customer findByUsername(String username){
        Customer  customer = costomerList.stream()
        .filter(c -> c.getName().equalIgnoreCase(username))
        .findFirst()
        .orElseThrow(()-> new UserPrincipalNotFoundException("User not found"));
        return customer;
    }

    
}
