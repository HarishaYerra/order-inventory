package com.example.orderinventory.inventory_service.dto;

import lombok.Data;

@Data
public class InventoryDTO {
	private Long productId;
    private Long storeId;
    private Integer productInventory;
}
