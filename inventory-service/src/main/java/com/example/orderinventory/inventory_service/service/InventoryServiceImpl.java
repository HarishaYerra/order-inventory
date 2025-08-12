package com.example.orderinventory.inventory_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderinventory.inventory_service.client.ProductIdClient;
import com.example.orderinventory.inventory_service.dto.ProductIdDTO;
import com.example.orderinventory.inventory_service.model.Inventory;
import com.example.orderinventory.inventory_service.model.Stores;
import com.example.orderinventory.inventory_service.repository.InventoryRepository;
import com.example.orderinventory.inventory_service.repository.StoresRepository;


@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private ProductIdClient productIdClient;
	
	@Autowired
	private StoresRepository storesRepository;

	@Override
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}
	
	@Override
	public Inventory saveInventory(Long storeId, Long productId, Integer quantity) {
		ProductIdDTO product =productIdClient.getProductId(productId);
		Stores store=storesRepository.findById(storeId)
				.orElseThrow(()-> new RuntimeException("Store not found with id:"+storeId));
		Inventory inventory =new Inventory();
		inventory.setStoreId(store);
		inventory.setProductId(product.getProductId());
		inventory.setProductInventory(quantity);
		return inventoryRepository.save(inventory);
	}
	@Override
	public 	ProductIdDTO getProductId(Long productId) {
		return productIdClient.getProductId(productId);
	}

}
