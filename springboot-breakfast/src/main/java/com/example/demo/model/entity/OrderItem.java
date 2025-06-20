package com.example.demo.model.entity;



import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
// 訂單
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnore                   // 避免無窮遞迴
	private OrderTable order;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private Integer itemPrice;

	
	
}
