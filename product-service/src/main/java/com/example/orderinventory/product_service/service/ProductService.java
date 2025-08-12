package com.example.orderinventory.product_service.service;

import java.util.List;

import com.example.orderinventory.product_service.exception.ProductException;
import com.example.orderinventory.product_service.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product createProduct(Product product);
	Product updateProduct(Long id, Product updatedProduct) throws ProductException;
	void deleteProduct(Long id) throws ProductException;
	Product getProductById(Long productId) throws ProductException;
	Product getProductByProductName(String productName) throws ProductException;
	List<Product> getProductByBrand(String brand) throws ProductException;
	List<Product> getProductByColour(String colour) throws ProductException;
}
