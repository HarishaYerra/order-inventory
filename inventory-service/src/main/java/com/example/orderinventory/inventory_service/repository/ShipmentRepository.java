package com.example.orderinventory.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderinventory.inventory_service.model.Shipments;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Long>{

}
