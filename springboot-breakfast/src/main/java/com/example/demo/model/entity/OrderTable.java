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
// OrderTable 是點餐頁面 例如當我在首頁典籍了 奶茶 就會進入到 OrderTable  // 然後在 OrderTable 裡面點加入購物車之後 就會跑到購物車之中
public class OrderTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId; // 要自動增加
	
	
	private Integer userId; // 對應使用者
	
	@OneToMany(mappedBy = "orderTable")
	private List<Item> items;
	
	
}
