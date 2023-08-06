package com.project.authenticate.externalService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.accountservice.dto;
import com.project.accountservice.entities.Customer;


@FeignClient(name="Customer-Service")
public interface ExternalCustomerService {
    
    @GetMapping("/{customerName}")
	public ResponseEntity<Customer> customerByName(@PathVariable String customerName);
}
