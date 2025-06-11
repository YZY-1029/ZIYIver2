package com.example.demo.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

// 商品分類表
public class ItemCategory {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(length = 50, nullable = false, unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference             // 避免在抓資料的時候無窮遞迴
    private List<Item> items;
}
