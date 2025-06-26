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
		
		ItemCategory cate3 = new ItemCategory();
		cate3.setCategoryName("漢堡");
		
		ItemCategory cate4 = new ItemCategory();
		cate4.setCategoryName("蛋餅");
		
		
		itemCategoryRepository.save(cate1);
		itemCategoryRepository.save(cate2);
		itemCategoryRepository.save(cate3);
		itemCategoryRepository.save(cate4);
	}
	
	
}
