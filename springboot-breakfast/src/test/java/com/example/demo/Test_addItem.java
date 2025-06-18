package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.ItemCategory;
import com.example.demo.repository.ItemCategoryRepository;
import com.example.demo.repository.ItemRepository;


@SpringBootTest
public class Test_addItem {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemCategoryRepository itemCategoryRepository;
	
	
	@Test
	public void addMultipleItem() {
		
		ItemCategory cate1 = itemCategoryRepository.findById(1).orElse(null); // 主食
		ItemCategory cate2 = itemCategoryRepository.findById(2).orElse(null); // 主食
		ItemCategory cate3 = itemCategoryRepository.findById(3).orElse(null); // 主食
		
		// 商品1
		Item item1 = new Item();
		item1.setItemName("煎餃");
		item1.setItemPrice(40);
		item1.setItemQty(99);
		item1.setBreakfastUrl("images/dumpling.png");
		item1.setCategory(cate1);
		
		
		Item item2 = new Item();
		item2.setItemName("紅茶");
		item2.setItemPrice(20);
		item2.setItemQty(50);
		item2.setBreakfastUrl("images/black-tea.png");
		item2.setCategory(cate2);
		
		Item item3 = new Item();
		item3.setItemName("咖啡");
		item3.setItemPrice(40);
		item3.setItemQty(70);
		item3.setBreakfastUrl("images/coffee-cup.png");
		item3.setCategory(cate2);
		
		Item item4 = new Item();
		item4.setItemName("炒泡麵");
		item4.setItemPrice(90);
		item4.setItemQty(30);
		item4.setBreakfastUrl("images/food.png");
		item4.setCategory(cate1);
		
		
		Item item5 = new Item();
		item5.setItemName("奶茶");
		item5.setItemPrice(30);
		item5.setItemQty(80);
		item5.setBreakfastUrl("images/milk-tea.png");
		item5.setCategory(cate2);
		
		Item item6 = new Item();
		item6.setItemName("綠茶");
		item6.setItemPrice(20);
		item6.setItemQty(61);
		item6.setBreakfastUrl("images/green-tea.png");
		item6.setCategory(cate2);
		
		
		Item item7 = new Item();
		item7.setItemName("牛肉漢堡");
		item7.setItemPrice(85);
		item7.setItemQty(66);
		item7.setBreakfastUrl("images/beff-burger.png");
		item7.setCategory(cate3);
		
		Item item8 = new Item();
		item8.setItemName("魚堡");
		item8.setItemPrice(80);
		item8.setItemQty(40);
		item8.setBreakfastUrl("images/fish-burger.png");
		item8.setCategory(cate3);
		
		Item item9 = new Item();
		item9.setItemName("薯條");
		item9.setItemPrice(40);
		item9.setItemQty(120);
		item9.setBreakfastUrl("images/fry-potato.png");
		item9.setCategory(cate1);
		
		Item item10 = new Item();
		item10.setItemName("小籠包");
		item10.setItemPrice(90);
		item10.setItemQty(50);
		item10.setBreakfastUrl("images/little-dumpling.png");
		item10.setCategory(cate1);
		
		Item item11 = new Item();
		item11.setItemName("豬肉漢堡");
		item11.setItemPrice(80);
		item11.setItemQty(100);
		item11.setBreakfastUrl("images/pork-burger.png");
		item11.setCategory(cate3);
		
		Item item12 = new Item();
		item12.setItemName("御飯糰");
		item12.setItemPrice(40);
		item12.setItemQty(55);
		item12.setBreakfastUrl("images/rice-ball.png");
		item12.setCategory(cate1);
		
		
		
		
		
		
		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);
		itemRepository.save(item4);
		itemRepository.save(item5);
		itemRepository.save(item6);
		itemRepository.save(item7);
		itemRepository.save(item8);
		itemRepository.save(item9);
		itemRepository.save(item10);
		itemRepository.save(item11);
		itemRepository.save(item12);
	}
	
	
}
