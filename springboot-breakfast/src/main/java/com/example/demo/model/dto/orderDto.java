package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.model.entity.OrderItem;

import lombok.Data;

@Data
public class orderDto {
	private String userName;
	private Integer orderId;
	private List<OrderItem> orderItems;
}
