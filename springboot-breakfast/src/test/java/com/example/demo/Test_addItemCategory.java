package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ItemCategory;
import com.example.demo.repository.ItemCategoryRepository;



@SpringBootTest
public class Test_addItemCategory {
	
	@Autowired
	ItemCategoryRepository itemCategoryRepository;
	
	
	@Test
	public void addItemCategory() {
		
		ItemCategory cate1 = new ItemCategory();
		cate1.setCategoryName("主食");
		

		ItemCategory cate2 = new ItemCategory();
		cate2.setCategoryName("飲料");
		
		itemCategoryRepository.save(cate1);
		itemCategoryRepository.save(cate2);
	}
	
	
}
