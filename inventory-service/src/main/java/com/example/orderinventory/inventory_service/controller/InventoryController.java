package com.example.orderinventory.inventory_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderinventory.inventory_service.dto.ProductIdDTO;
import com.example.orderinventory.inventory_service.model.Inventory;
import com.example.orderinventory.inventory_service.service.InventoryService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
		
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping
	public ResponseEntity<List<Inventory>> getAllInventory(){
		return ResponseEntity.ok(inventoryService.getAllInventory());
	}
	
	@PostMapping("/store/{storeId}/product/{productId}/quantity/{quantity}")
	public ResponseEntity<Inventory> saveInventory(@PathVariable Long storeId , @PathVariable Long productId, @PathVariable Integer quantity){
		
		Inventory savedInventory=inventoryService.saveInventory(storeId,productId , quantity);
		
		return ResponseEntity.ok(savedInventory);
	}
	
	@GetMapping("/{productId}/id")
	public ProductIdDTO getProductId(@PathVariable Long productId){
		return inventoryService.getProductId(productId);
	}
}
