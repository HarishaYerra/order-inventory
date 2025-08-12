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
public class Shipments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long shipmentId;
	private Long customerId;
	private String address;
	private String shipmentStatus;
	

	public Long getShipmentId() {
		return shipmentId;
	}



	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getShipmentStatus() {
		return shipmentStatus;
	}



	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}



	public Stores getStore() {
		return store;
	}



	public void setStore(Stores store) {
		this.store = store;
	}



	@Override
	public String toString() {
		return "Shipments [shipmentId=" + shipmentId+ ", customerId=" + customerId
				+ ", address=" + address + ", shipmentStatus=" + shipmentStatus + ", store=" + store + "]";
	}
	
	@ManyToOne
    @JoinColumn(name = "store_id") // name must match DB column
    private Stores store;
}
