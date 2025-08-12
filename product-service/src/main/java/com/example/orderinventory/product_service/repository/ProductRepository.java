package com.example.orderinventory.product_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderinventory.product_service.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	Product getProductByProductName(String productName);
	List<Product> getProductByColour(String colour);
	List<Product> getProductByBrand(String brand);

}
