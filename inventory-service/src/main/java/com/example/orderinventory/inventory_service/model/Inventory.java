package com.example.orderinventory.inventory_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long inventoryId;
	private Long productId;
	private Integer productInventory;

	public Long getInventoryId() {
		return inventoryId;
	}



	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}


	public Long getProductId() {
		return productId;
	}



	public void setProductId(Long productId) {
		this.productId = productId;
	}



	public Integer getProductInventory() {
		return productInventory;
	}



	public void setProductInventory(Integer productInventory) {
		this.productInventory = productInventory;
	}



	public Stores getStoreId() {
		return store;
	}



	public void setStoreId(Stores store) {
		this.store = store;
	}



	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ",productId=" + productId
				+ ", productInventory=" + productInventory + ", store=" + store + "]";
	}
	
	@ManyToOne
    @JoinColumn(name = "store_id") // name must match DB column
    private Stores store;
}
