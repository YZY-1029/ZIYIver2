package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 用戶
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
	private Boolean active;

	@Column(name = "role")
	private String role;
	
	
	
	
}
