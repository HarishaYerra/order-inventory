package com.example.orderinventory.inventory_service.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stores {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long storeId;
	private String storeName;
	
	// Optional: bidirectional mapping
//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
//    private List<Shipments> shipments;
//    
 // Optional: bidirectional mapping
    //@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
   // private List<Shipments> shipments;

}
