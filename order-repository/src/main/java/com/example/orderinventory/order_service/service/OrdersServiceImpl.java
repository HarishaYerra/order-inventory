package com.example.orderinventory.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderinventory.order_service.client.CustomerClient;
import com.example.orderinventory.order_service.client.ProductClient;
import com.example.orderinventory.order_service.dto.CustomerDTO;
import com.example.orderinventory.order_service.dto.OrderWithCustomerDTO;
import com.example.orderinventory.order_service.dto.ProductMinimalDTO;
import com.example.orderinventory.order_service.model.Orders;
import com.example.orderinventory.order_service.model.OrdersItem;
import com.example.orderinventory.order_service.repository.OrdersRepository;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    
    @Autowired
    private CustomerClient customerClient;
    
    @Autowired
    private ProductClient productClient;

   
    public Orders createOrders(Orders order) {
    	// For each order item in the order
        for (OrdersItem item : order.getOrderItems()) {
            // Fetch product details from Product service
            ProductMinimalDTO productDTO = productClient.getProductById(item.getProductId());

            // Set unit price and product ID from ProductMinimalDTO
            item.setUnitPrice(productDTO.getUnitPrice());
            item.setProductId(productDTO.getProductId());

            // Ensure bi-directional relationship is set (important for JPA cascade)
            item.setOrders(order);
        }

        // Save the complete order with updated items
        return ordersRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }
    
    public OrderWithCustomerDTO getOrderWithCustomer(Long orderId) {
        Orders order = ordersRepository.findById(orderId)
                        .orElseThrow(() -> new RuntimeException("Order not found"));

        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());

        OrderWithCustomerDTO dto = new OrderWithCustomerDTO();
        dto.setOrder(order);
        dto.setCustomer(customer);
        return dto;
    }
    
    
    public ProductMinimalDTO fetchProductMinimalDTO(Long productId) {
        return productClient.getProductById(productId);
    }
  
}
