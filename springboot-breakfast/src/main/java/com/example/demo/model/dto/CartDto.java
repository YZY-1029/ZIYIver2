package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class CartDto {
	private Integer userId;
	private Integer itemId;
	private Integer quantity;
}
