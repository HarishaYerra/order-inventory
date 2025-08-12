package com.example.orderinventory.inventory_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderinventory.inventory_service.dto.ProductIdDTO;
import com.example.orderinventory.inventory_service.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    //Optional<Inventory> findByProductIdAndStoreId(Long productId, Long storeId);
}

