package com.example.orderinventory.product_service.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductMinimalDTO {
	private Long productId;
    private Long unitPrice;
}
