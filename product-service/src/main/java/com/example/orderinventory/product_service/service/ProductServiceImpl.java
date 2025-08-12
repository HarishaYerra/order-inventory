package com.example.orderinventory.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderinventory.product_service.exception.ProductException;
import com.example.orderinventory.product_service.model.Product;
import com.example.orderinventory.product_service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	
	public 	Product createProduct(Product dto) {
		Product product =new Product();
		product.setProductName(dto.getProductName());
		product.setUnitPrice(dto.getUnitPrice());
		product.setColour(dto.getColour());
		product.setBrand(dto.getBrand());
		product.setSize(dto.getSize());
		product.setRatting(dto.getRatting());
		return productRepository.save(product);

	}
	
	
	public 	Product updateProduct(Long id,Product updatedProduct) throws ProductException{
		Product existing = productRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Product not found with id"+ id));
		existing.setProductName(updatedProduct.getProductName());
		existing.setUnitPrice(updatedProduct.getUnitPrice());
		existing.setColour(updatedProduct.getColour());
		existing.setBrand(updatedProduct.getBrand());
		existing.setSize(updatedProduct.getSize());
		existing.setRatting(updatedProduct.getRatting());
		return productRepository.save(existing);

	}
	
	
	public void deleteProduct(Long id) throws ProductException{
		productRepository.deleteById(id);
	}
	
	@Override
	public Product getProductById(Long productId) throws ProductException {
	    return productRepository.findById(productId)
	            .orElseThrow(() -> new ProductException("Product not found with id: " + productId));
	}

	
	public Product getProductByProductName(String productName) throws ProductException{
		return productRepository.getProductByProductName(productName);
				//.orElseThrow(() -> new ProductException("Product not found with id: " + productName));
		
	}

	
	public 	List<Product> getProductByColour(String colour) throws ProductException{
		return productRepository.getProductByColour(colour);
				//.orElseThrow(() -> new ProductException("Product not found with id: " + colour));;
		
	}
	
	
	public 	List<Product> getProductByBrand(String brand) throws ProductException{
		return productRepository.getProductByBrand(brand);
		
	}
		
}
