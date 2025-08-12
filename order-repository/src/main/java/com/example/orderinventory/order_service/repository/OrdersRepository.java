package com.example.orderinventory.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderinventory.order_service.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders , Long> {

}
