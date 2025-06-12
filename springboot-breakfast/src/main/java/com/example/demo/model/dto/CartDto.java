package com.example.demo.model.dto;

import lombok.Data;


@Data
public class CartDto {
	private Integer userId;
	private Integer itemId;
	private Integer quantity;
}
