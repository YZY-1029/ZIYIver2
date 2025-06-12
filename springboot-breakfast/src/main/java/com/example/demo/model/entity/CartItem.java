package com.example.demo.model.entity;

import java.util.List;

import org.hibernate.annotations.Collate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
// 購物車與商品ㄉ中介表
public class CartItem {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartItemId;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(nullable = false)
	private Integer quantity;
	
}
