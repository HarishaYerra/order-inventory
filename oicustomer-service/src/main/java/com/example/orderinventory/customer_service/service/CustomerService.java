package com.example.orderinventory.customer_service.service;

import java.util.List;

import com.example.orderinventory.customer_service.exception.CustomerException;
import com.example.orderinventory.customer_service.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();

	Customer createCustomer(Customer customer);

	Customer updateCustomer(Long id, Customer updatedCustomer) throws CustomerException;

	void deleteCustomer(Long id);

	Customer getCustomerById(Long id) throws CustomerException;

	List<Customer> getCustomerByEmail(String email) throws CustomerException ;

	List<Customer> getCustomerByName(String name);
}
