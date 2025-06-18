package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderTableRepository;
import com.example.demo.service.CheckOut;

import jakarta.servlet.http.HttpSession;

@Service
public class CheckOutImpl implements CheckOut {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private OrderTableRepository orderTableRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	// 結帳 -> 先確定庫存夠不夠 ->  不夠的話拋出例外
	//          	 	 ->  夠的話將該使用者的購物車丟進資料庫中ㄉ歷史紀錄 -> 再將該使用者資料庫中ㄉ的購物車清除 -> 前端抓取該使用者資料庫中的歷史紀錄資料
	@Override
	@Transactional
	public void checkOut(HttpSession session) {
		// 1. 查購物車
		List<CartItem> cartItem = cartItemRepository.findAll();
		// 2. 扣庫存   商品 qty 跟 cartItem.quantity 去比
		for(CartItem e : cartItem) {
			
			Optional<Item> opt = itemRepository.findById(e.getItem().getItemId());
			if(!opt.isPresent()) {
				throws new RuntimeException("找不到產品");
			}
		}
		
		
		
		// 3. 存到歷史訂單
		
		
		
		// 4. 清空購物車
		
		
		
	}

}
