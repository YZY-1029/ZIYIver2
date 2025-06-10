//package com.example.demo.model.entity;
//
//import java.util.List;
//
//import org.hibernate.annotations.Collate;
//
//import jakarta.annotation.Generated;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class CartItem {
//	
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer CartItemId;
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@OneToMany
//	@Column(name = "item_id")
//	private List<Item> items;
//	
//	@Column(nullable = false)
//	private Integer quantity;
//	
//}
