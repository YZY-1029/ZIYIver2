package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Item;
import com.example.demo.repository.ItemRepository;


@SpringBootTest
public class Test_addItem {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void addMultipleItem() {
		
		// 商品1
		Item item1 = new Item();
		item1.setItemName("煎餃");
		item1.setItemPrice(40);
		item1.setItemQty(99);
		item1.setBreakfastUrl("URL/dumping.png");
		
		
		
		Item item2 = new Item();
		item2.setItemName("紅茶");
		item2.setItemPrice(20);
		item2.setItemQty(50);
		item2.setBreakfastUrl("URL/blcak.png");
		
		Item item3 = new Item();
		item3.setItemName("咖啡");
		item3.setItemPrice(40);
		item3.setItemQty(70);
		item3.setBreakfastUrl("URL/coffee.png");
		
		Item item4 = new Item();
		item4.setItemName("炒泡麵");
		item4.setItemPrice(90);
		item4.setItemQty(30);
		item4.setBreakfastUrl("URL/food.png");
		
		Item item5 = new Item();
		item5.setItemName("奶茶");
		item5.setItemPrice(30);
		item5.setItemQty(80);
		item5.setBreakfastUrl("URL/milk-tea.png");
		
		Item item6 = new Item();
		item6.setItemName("綠茶");
		item6.setItemPrice(20);
		item6.setItemQty(61);
		item6.setBreakfastUrl("URL/green-tea.png");
		
		
		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);
		itemRepository.save(item4);
		itemRepository.save(item5);
		itemRepository.save(item6);
	}
	
	
}
