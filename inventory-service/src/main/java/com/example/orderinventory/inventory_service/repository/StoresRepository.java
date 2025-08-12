package com.example.orderinventory.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderinventory.inventory_service.model.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Long> {

}
