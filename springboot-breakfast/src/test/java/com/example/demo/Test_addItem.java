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
		ItemCategory cate2 = itemCategoryRepository.findById(2).orElse(null); // 飲料
		ItemCategory cate3 = itemCategoryRepository.findById(3).orElse(null); // 漢堡
		ItemCategory cate4 = itemCategoryRepository.findById(4).orElse(null); // 蛋餅
		
//		// 商品1
//		Item item1 = new Item();
//		item1.setItemName("煎餃");
//		item1.setItemPrice(40);
//		item1.setItemQty(99);
//		item1.setBreakfastUrl("images/dumpling.png");
//		item1.setCategory(cate1);
//		
//		
//		Item item2 = new Item();
//		item2.setItemName("紅茶");
//		item2.setItemPrice(20);
//		item2.setItemQty(50);
//		item2.setBreakfastUrl("images/black-tea.png");
//		item2.setCategory(cate2);
//		
//		Item item3 = new Item();
//		item3.setItemName("咖啡");
//		item3.setItemPrice(40);
//		item3.setItemQty(70);
//		item3.setBreakfastUrl("images/coffee-cup.png");
//		item3.setCategory(cate2);
//		
//		Item item4 = new Item();
//		item4.setItemName("炒泡麵");
//		item4.setItemPrice(90);
//		item4.setItemQty(30);
//		item4.setBreakfastUrl("images/food.png");
//		item4.setCategory(cate1);
//		
//		
//		Item item5 = new Item();
//		item5.setItemName("奶茶");
//		item5.setItemPrice(30);
//		item5.setItemQty(80);
//		item5.setBreakfastUrl("images/milk-tea.png");
//		item5.setCategory(cate2);
//		
//		Item item6 = new Item();
//		item6.setItemName("綠茶");
//		item6.setItemPrice(20);
//		item6.setItemQty(61);
//		item6.setBreakfastUrl("images/green-tea.png");
//		item6.setCategory(cate2);
//		
//		
//		Item item7 = new Item();
//		item7.setItemName("牛肉漢堡");
//		item7.setItemPrice(85);
//		item7.setItemQty(66);
//		item7.setBreakfastUrl("images/beff-burger.png");
//		item7.setCategory(cate3);
//		
//		Item item8 = new Item();
//		item8.setItemName("魚堡");
//		item8.setItemPrice(80);
//		item8.setItemQty(40);
//		item8.setBreakfastUrl("images/fish-burger.png");
//		item8.setCategory(cate3);
//		
//		Item item9 = new Item();
//		item9.setItemName("薯條");
//		item9.setItemPrice(40);
//		item9.setItemQty(120);
//		item9.setBreakfastUrl("images/fry-potato.png");
//		item9.setCategory(cate1);
//		
//		Item item10 = new Item();
//		item10.setItemName("小籠包");
//		item10.setItemPrice(90);
//		item10.setItemQty(50);
//		item10.setBreakfastUrl("images/little-dumpling.png");
//		item10.setCategory(cate1);
//		
//		Item item11 = new Item();
//		item11.setItemName("豬肉漢堡");
//		item11.setItemPrice(80);
//		item11.setItemQty(100);
//		item11.setBreakfastUrl("images/pork-burger.png");
//		item11.setCategory(cate3);
//		
//		Item item12 = new Item();
//		item12.setItemName("御飯糰");
//		item12.setItemPrice(40);
//		item12.setItemQty(55);
//		item12.setBreakfastUrl("images/rice-ball.png");
//		item12.setCategory(cate1);
//		
//		
//		
//		
//		
//		
//		itemRepository.save(item1);
//		itemRepository.save(item2);
//		itemRepository.save(item3);
//		itemRepository.save(item4);
//		itemRepository.save(item5);
//		itemRepository.save(item6);
//		itemRepository.save(item7);
//		itemRepository.save(item8);
//		itemRepository.save(item9);
//		itemRepository.save(item10);
//		itemRepository.save(item11);
//		itemRepository.save(item12);
		
		Item item13 = new Item();
		item13.setItemName("鍋貼");
		item13.setItemPrice(50);
		item13.setItemQty(99);
		item13.setBreakfastUrl("images/a.jpg");
		item13.setCategory(cate1);
		
		Item item14 = new Item();
		item14.setItemName("培根蛋餅");
		item14.setItemPrice(50);
		item14.setItemQty(50);
		item14.setBreakfastUrl("images/baconroll.jpg");
		item14.setCategory(cate4);

		Item item15 = new Item();
		item15.setItemName("牛肉漢堡");
		item15.setItemPrice(100);
		item15.setItemQty(80);
		item15.setBreakfastUrl("images/beefburger.jpg");
		item15.setCategory(cate3);
		
		Item item16 = new Item();
		item16.setItemName("紅茶");
		item16.setItemPrice(20);
		item16.setItemQty(99);
		item16.setBreakfastUrl("images/blackTea.jpg");
		item16.setCategory(cate2);
		
		Item item17 = new Item();
		item17.setItemName("起司蛋餅");
		item17.setItemPrice(50);
		item17.setItemQty(99);
		item17.setBreakfastUrl("images/chessroll.jpg");
		item17.setCategory(cate4);
		
		Item item18 = new Item();
		item18.setItemName("玉米蛋餅");
		item18.setItemPrice(50);
		item18.setItemQty(65);
		item18.setBreakfastUrl("images/cornroll.jpg");
		item18.setCategory(cate4);
		
		Item item19 = new Item();
		item19.setItemName("魚堡");
		item19.setItemPrice(75);
		item19.setItemQty(88);
		item19.setBreakfastUrl("images/fishburger.jpg");
		item19.setCategory(cate3);
		
		Item item20 = new Item();
		item20.setItemName("鮪魚蛋餅");
		item20.setItemPrice(50);
		item20.setItemQty(89);
		item20.setBreakfastUrl("images/fishroll.jpg");
		item20.setCategory(cate4);
		
		Item item21 = new Item();
		item21.setItemName("炒泡麵");
		item21.setItemPrice(50);
		item21.setItemQty(99);
		item21.setBreakfastUrl("images/frynoodle.jpg");
		item21.setCategory(cate1);
		
		Item item22 = new Item();
		item22.setItemName("薯條");
		item22.setItemPrice(50);
		item22.setItemQty(99);
		item22.setBreakfastUrl("images/frypotato.jpg");
		item22.setCategory(cate1);
		
		Item item23 = new Item();
		item23.setItemName("蘿蔔糕");
		item23.setItemPrice(50);
		item23.setItemQty(99);
		item23.setBreakfastUrl("images/lobojpg.jpg");
		item23.setCategory(cate1);
		
		Item item24 = new Item();
		item24.setItemName("豬肉漢堡");
		item24.setItemPrice(50);
		item24.setItemQty(99);
		item24.setBreakfastUrl("images/porkburger.jpg");
		item24.setCategory(cate3);
		
		Item item25 = new Item();
		item25.setItemName("豬肉蛋餅");
		item25.setItemPrice(55);
		item25.setItemQty(99);
		item25.setBreakfastUrl("images/porkroll.jpg");
		item25.setCategory(cate4);
		
		Item item26 = new Item();
		item26.setItemName("小籠包");
		item26.setItemPrice(55);
		item26.setItemQty(99);
		item26.setBreakfastUrl("images/smalldrogan.jpg");
		item26.setCategory(cate1);
		
		
		Item item27 = new Item();
		item27.setItemName("咖啡");
		item27.setItemPrice(40);
		item27.setItemQty(33);
		item27.setBreakfastUrl("images/coffee.jpg");
		item27.setCategory(cate2);

		Item item28 = new Item();
		item28.setItemName("綠茶");
		item28.setItemPrice(20);
		item28.setItemQty(107);
		item28.setBreakfastUrl("images/greentea.jpg");
		item28.setCategory(cate2);
		
		Item item29 = new Item();
		item29.setItemName("拿鐵");
		item29.setItemPrice(50);
		item29.setItemQty(40);
		item29.setBreakfastUrl("images/latte.jpg");
		item29.setCategory(cate2);
		
		Item item30 = new Item();
		item30.setItemName("奶茶");
		item30.setItemPrice(55);
		item30.setItemQty(99);
		item30.setBreakfastUrl("images/milktea.jpg");
		item30.setCategory(cate2);
		
		Item item31 = new Item();
		item31.setItemName("柳橙汁");
		item31.setItemPrice(35);
		item31.setItemQty(56);
		item31.setBreakfastUrl("images/orange.jpg");
		item31.setCategory(cate2);
		
		
		itemRepository.save(item13);
		itemRepository.save(item14);
		itemRepository.save(item15);
		itemRepository.save(item16);
		itemRepository.save(item17);
		itemRepository.save(item18);
		itemRepository.save(item19);
		itemRepository.save(item20);
		itemRepository.save(item21);
		itemRepository.save(item22);
		itemRepository.save(item23);
		itemRepository.save(item24);
		itemRepository.save(item25);
		itemRepository.save(item26);
		itemRepository.save(item27);
		itemRepository.save(item28);
		itemRepository.save(item29);
		itemRepository.save(item30);
		itemRepository.save(item31);

	}
	
	
	
}
