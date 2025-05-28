package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 訂單
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId; // 要自動增加
	
	private Integer userId; // 動應使用者
	
	@OneToMany(mappedBy = "itemName")
	private List<Item> orderItems;
	
	private Integer totalPrice;
}
