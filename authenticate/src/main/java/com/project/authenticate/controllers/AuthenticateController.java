package com.project.authenticate.controllers;

import com.project.authenticate.loginReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.project.authenticate.entities.Customer;
import com.project.authenticate.external.CustomerIntf;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {

	@Autowired
	CustomerIntf customer;

	@Autowired
	private JWTUtils jwtUtils;
	@Autowired
	private AuthenticationProvider authenticationManager;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDTO loginRequestDTO) {
		String token = null;
		LoginResponseDTO loginResponseDTO = null;
		Map<String, Object> claims = new HashMap<>();
		Set<String> roles = new HashSet<>();
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
						loginRequestDTO.getPassword()));
		UserDetails userDetails = userService.loadUserByUsername(loginRequestDTO.getUsername());
		token = jwtUtils.generateToken(claims, loginRequestDTO.getUsername());

		return token;

	}

	@GetMapping("/{custId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int custId) {
		System.out.println("Hey");
		ResponseEntity<Customer> cust = customer.getCustomer(custId);
		return cust;

	}

}
