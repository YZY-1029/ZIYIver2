package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 使用者
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId; // 自動增加 
	
	
	@Column(length = 50, nullable = false)
	private String userName;
	
	@Column(length = 50, nullable = false, unique = true)
	private String userEmail; // 確認是否註冊過
	
	@Column(length = 100, nullable = false)
	private String salt;
	
	@Column(length = 100, nullable = false)
	private String userPassword; // 雜湊 加鹽 可重複
	
	@Column(columnDefinition = "TINYINT(1) DEFAULT 0")
	private Boolean active = false;    // 一開始為 false 未驗證    // 要去email進行驗證

	@Column(name = "role")
	private String role = "user";
	
//	@OneToMany(mappedBy = "user")
//	private List<CartItem> cartItems;
	
	
	
	
}
