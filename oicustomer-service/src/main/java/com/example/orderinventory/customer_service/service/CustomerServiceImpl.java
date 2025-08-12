package com.example.orderinventory.customer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderinventory.customer_service.exception.CustomerException;
import com.example.orderinventory.customer_service.model.Customer;
import com.example.orderinventory.customer_service.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer dto) {
		Customer customer = new Customer();
		customer.setEmail(dto.getEmail());
		customer.setName(dto.getName());
		return customerRepository.save(customer);

	}

	@Override
	public Customer updateCustomer(Long id, Customer updatedCustomer) throws CustomerException {
		Customer existing = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerException("Customer not found with id: " + id));
		existing.setEmail(updatedCustomer.getEmail());
		existing.setName(updatedCustomer.getName());
		return customerRepository.save(existing);

	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getCustomerById(Long id) throws CustomerException {
		return customerRepository.findById(id)
				.orElseThrow(() -> new CustomerException("Customer not found with id: " + id));
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) throws CustomerException {
		List<Customer> customers = customerRepository.getCustomerByEmail(email);
		if (customers.isEmpty()) {
			throw new CustomerException("Customer not found with email: " + email);
		}
		return customers;
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		return customerRepository.getCustomerByName(name);
	}

}
