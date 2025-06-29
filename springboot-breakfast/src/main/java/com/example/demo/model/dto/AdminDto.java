package com.example.demo.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.entity.OrderItem;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AdminDto {
	private Integer orderId;
	private String userName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderTime;
   	private Integer totalPrice;
   	private String note;
   	private List<OrderItem> orderItems;  
}
