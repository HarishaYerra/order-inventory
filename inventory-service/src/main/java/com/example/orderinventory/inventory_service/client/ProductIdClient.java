package com.example.orderinventory.inventory_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderinventory.inventory_service.dto.ProductIdDTO;

@FeignClient(name="product-service")
public interface ProductIdClient {
	
	@GetMapping("/api/v1/products/{productId}/id")
	ProductIdDTO getProductId(@PathVariable("productId") Long productId);
}
