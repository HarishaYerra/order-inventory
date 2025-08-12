package com.example.orderinventory.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderinventory.order_service.dto.ProductMinimalDTO;

@FeignClient(name="product-service", url="http://localhost:8082")
public interface ProductClient {
	
	@GetMapping("/api/v1/products/{productId}/minimal")
	ProductMinimalDTO getProductById(@PathVariable("productId") Long productId);
}
