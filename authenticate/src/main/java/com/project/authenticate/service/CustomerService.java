package com.project.authenticate.service;
import com.project.authenticate.repository.*;
import com.project.authenticate.entity.Customer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService{

    private CustomerRepository customerRepository;

    private BCryptPasswordEncoder passwordEncoder;


    public UserDetails loadUserByUsername(String username){
        Customer customer  = customerRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found.");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(customer.getName(),
                customer.getPassword(), null);
        return userDetails;
    }

   
    
    
}
