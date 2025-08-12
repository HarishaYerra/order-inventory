package com.example.orderinventory.inventory_service.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.orderinventory.inventory_service.dto.ProductIdDTO;
import com.example.orderinventory.inventory_service.model.Inventory;

public interface InventoryService {

	List<Inventory> getAllInventory();
	Inventory saveInventory(Long storeId, Long productId, Integer quantity);
	ProductIdDTO getProductId(Long productId);
}
