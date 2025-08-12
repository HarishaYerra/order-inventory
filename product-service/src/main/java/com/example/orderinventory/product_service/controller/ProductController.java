package com.example.orderinventory.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.orderinventory.product_service.dto.ProductIdDTO;
import com.example.orderinventory.product_service.dto.ProductMinimalDTO;
import com.example.orderinventory.product_service.exception.ProductException;
import com.example.orderinventory.product_service.model.Product;
import com.example.orderinventory.product_service.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public 	ResponseEntity<Product> createProduct(@RequestBody Product dto) {
		Product created = productService.createProduct(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);

	}
	
	
	@PutMapping("/{id}")
	public 	ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product dto) throws ProductException{
		Product updated = productService.updateProduct(id ,dto);
		return ResponseEntity.ok(updated);

	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductException{
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted Successfully");
	}
	
	@GetMapping("/productName/{productName}")
	public Product getProductByProductName(@PathVariable("productName") String productName) throws ProductException{
		return productService.getProductByProductName(productName);
		
	}

	@GetMapping("/colour/{colour}")
	public 	List<Product> getProductByColour(@PathVariable("colour") String colour) throws ProductException{
		return productService.getProductByColour(colour);
		
	}
	
	@GetMapping("/brand")
	public 	List<Product> getProductByBrand(@RequestParam String brand) throws ProductException{
		return productService.getProductByBrand(brand);
		
	}
	
	@GetMapping("/{productId}/minimal")
	public ProductMinimalDTO getMinimalProduct(@PathVariable Long productId) throws ProductException{
	    Product product = productService.getProductById(productId); // or repo
	    ProductMinimalDTO dto = new ProductMinimalDTO();
	    dto.setProductId(product.getProductId());
	    dto.setUnitPrice(product.getUnitPrice());
	    return dto;
	}
	
	@GetMapping("/{productId}/id")
	public ProductIdDTO getProductId(@PathVariable Long productId) throws ProductException{
		Product product = productService.getProductById(productId);
		ProductIdDTO dto= new ProductIdDTO();
		dto.setProductId(product.getProductId());
		return dto;
		
	}
	
}
