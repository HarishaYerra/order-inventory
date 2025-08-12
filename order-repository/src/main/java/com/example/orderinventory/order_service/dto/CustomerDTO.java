package com.example.orderinventory.order_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO {
	@JsonProperty("customerId")
	private Long id;
    private String name;
    private String email;
}
