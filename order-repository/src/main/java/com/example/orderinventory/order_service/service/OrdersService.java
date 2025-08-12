package com.example.orderinventory.order_service.service;

import java.util.List;

import com.example.orderinventory.order_service.dto.OrderWithCustomerDTO;
import com.example.orderinventory.order_service.dto.ProductMinimalDTO;
import com.example.orderinventory.order_service.model.Orders;
import com.example.orderinventory.order_service.model.OrdersItem;

public interface OrdersService {

	List<Orders> getAllOrders();
	Orders createOrders(Orders dto);
	void deleteOrders(Long id);
	Orders getOrdersById(Long id);
	OrderWithCustomerDTO getOrderWithCustomer(Long orderId);
	ProductMinimalDTO fetchProductMinimalDTO(Long productId);

}
