package com.example.orderinventory.order_service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderinventory.order_service.dto.OrderWithCustomerDTO;
import com.example.orderinventory.order_service.dto.ProductMinimalDTO;
import com.example.orderinventory.order_service.model.Orders;
import com.example.orderinventory.order_service.service.OrdersService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        return ResponseEntity.ok(ordersService.createOrders(orders));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable Long id) {
        return ResponseEntity.ok(ordersService.getOrdersById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
    
    @GetMapping("/{orderId}/customer")
    public ResponseEntity<OrderWithCustomerDTO> getOrderWithCustomer(@PathVariable Long orderId) {
        OrderWithCustomerDTO response = ordersService.getOrderWithCustomer(orderId);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{productId}/minimal")
    public ResponseEntity<ProductMinimalDTO> getProductDetails(@PathVariable Long productId) {
        ProductMinimalDTO product = ordersService.fetchProductMinimalDTO(productId);
        return ResponseEntity.ok(product);
    }


}

