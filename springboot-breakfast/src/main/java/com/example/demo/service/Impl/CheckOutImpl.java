package com.example.demo.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.UserCert;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.OrderTable;
import com.example.demo.model.entity.User;
import com.example.demo.repository.*;
import com.example.demo.service.CheckOut;


import jakarta.servlet.http.HttpSession;

@Service
public class CheckOutImpl implements CheckOut {

    private final CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private OrderTableRepository orderTableRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;

	

    CheckOutImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
	
	
	// 結帳
	@Override
	@Transactional
	public List<CartItem> checkOut(HttpSession session, String note) {
		
		// 先找使用者
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		if (userCert == null) {
			throw new RuntimeException("請先登入再結帳");
		}
		Integer userId = userCert.getUserId();
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("找不到購物車"));
		
		
		// 取得購物車內ㄉ商品
		Cart cart = cartRepository.findByUser(user)
				.orElseThrow(() -> new RuntimeException("找不到使用者的購物車"));
		
		List<CartItem> cartItems = cart.getCartItems();
		if (cartItems.isEmpty()) {
			throw new RuntimeException("找不到購物車,或購物車是空的");
		}
		
		// 檢查商品的庫存是否足夠
		for (CartItem cartItem : cartItems) {
			Item item = cartItem.getItem();
			
			if(item.getItemQty() < cartItem.getQuantity()) {
				throw new RuntimeException("商品" + item.getItemName() + "庫存不夠");
			}
		}
		
		// 足夠的話扣數量
		for( CartItem cartItem : cartItems ) {
			Item item = cartItem.getItem();
			
			item.setItemQty(item.getItemQty() - cartItem.getQuantity());     // 商品庫存變成 商品庫存 - 購物數量
			itemRepository.save(item);    // 將扣除好的商品 存到itemRepository 
		}
		
		// 再將購物車的東西存到 orderTable裡 歷史清單
		OrderTable order = new OrderTable();
		order.setUser(cartItems.get(0).getCart().getUser());
		order.setOrderTime(LocalDateTime.now());
		order.setNote(note);
		
		Integer totalPrice = 0;
		
		// 存進去
		for( CartItem cartItem : cartItems ) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(cartItem.getItem());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setItemPrice(cartItem.getItem().getItemPrice());
			
			totalPrice += cartItem.getItem().getItemPrice() * cartItem.getQuantity();
			
			order.addOrderItem(orderItem);
		}
		order.setTotalPrice(totalPrice);
		orderTableRepository.save(order);
		
		
		// 將購物車清空
		cart.getCartItems().clear();
		cartRepository.save(cart);
		
		return cartItems;
	}

	// 加到歷史清單裡面
	@Override
	public List<OrderTable> getOrderHistory(HttpSession session) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		if( userCert == null ) {
			throw new RuntimeException("請先登入才能查看歷史訂單");
		}
		
		Integer userId = userCert.getUserId();
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("找不到使用者"));
		
		return orderTableRepository.findByUser(user);
	}
}

