package com.example.orderinventory.customer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderinventory.customer_service.exception.CustomerException;
import com.example.orderinventory.customer_service.model.Customer;
import com.example.orderinventory.customer_service.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@PostMapping
	public ResponseEntity<Customer> createAccount(@Valid @RequestBody Customer dto){
		Customer created = customerService.createCustomer(dto);
		return ResponseEntity.ok(created);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer dto) throws CustomerException {
		return customerService.updateCustomer(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok("Customer Deleted Successfully");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws CustomerException {
	    Customer customer = customerService.getCustomerById(id);
	    return ResponseEntity.ok(customer);
	}

	
	@GetMapping("/email")
	public 	List<Customer> getCustomerByEmail(@RequestParam("email") String email) throws CustomerException{
		return customerService.getCustomerByEmail(email);
		
	}
	
	@GetMapping("/full_name/{full_name}")
	public 	List<Customer> getCustomerByName(@PathVariable("full_name") String name){
		return customerService.getCustomerByName(name);
	}
	
}


