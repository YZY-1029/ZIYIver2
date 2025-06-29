package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderTableDto {
	private String itemName;
	private Integer Category_id;
	private Integer quantity;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderTime; 
}
