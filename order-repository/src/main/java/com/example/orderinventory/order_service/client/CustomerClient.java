package com.example.orderinventory.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderinventory.order_service.dto.CustomerDTO;

@FeignClient(name = "customer-service",url = "http://localhost:8081") // name matches application name of customer-service

public interface CustomerClient {
	@GetMapping("/api/v2/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable("id") Long customerId);
}
