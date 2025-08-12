package com.example.orderinventory.order_service.dto;

import com.example.orderinventory.order_service.model.Orders;

import lombok.Data;


@Data
public class OrderWithCustomerDTO {
	private Orders order;
    private CustomerDTO customer;
   
}
