package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 物品

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId; // 要自動增加
	
	@Column(length = 50, nullable = false)
	private String itemName;
	
	@Column(length = 50, nullable = false)
	private Integer itemPrice;
	
	@Column(length = 50, nullable = false)
	private Integer itemQty;
	
	@Column(length = 250, nullable = false)
	private String breakfastUrl;
	

	

}
