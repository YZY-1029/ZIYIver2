package com.example.demo.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderTableDto {
	private String itemName;
	private Integer Category_id;
	private Integer quantity;
	private LocalDateTime orderTime; 
}
