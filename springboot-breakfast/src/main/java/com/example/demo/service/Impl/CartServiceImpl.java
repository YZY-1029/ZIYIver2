package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.User;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	// 新增商品到使用者ㄉ購物車裡面
	@Override
	public void addItemToCart(Integer userId, Integer itemId, Integer quantity) {
		// 對應商品以及對應用戶
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("使用者不存在"));
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("商品不存在"));
		
		// 檢查使用者是否已經有購物車, 沒有的話先初始化
		Cart cart = cartRepository.findByUser(user).orElse(null);
		
		if (cart == null) {
			cart = new Cart();
			cart.setUser(user);
			cart.setCartItems(new ArrayList<>()); // 初始化購物車
		}
		// 檢查購物車是否有相同的商品, 有ㄉ話直接更改數量
		Optional<CartItem> existingItem = cart.getCartItems()
											  .stream()
											  .filter( aaa -> aaa.getItem().getItemId().equals(itemId))
											  .findFirst();
		// 如果購物車中已存在相同id商品, 則把那商品放到cartItem中, 並將cartItem(購物車中ㄉ某一商品)ㄉ數量重新設定為 原先存在數量 + 現在增加數量     最終再放進購物車中
		if (existingItem.isPresent()) {
			CartItem cartItem = existingItem.get();
			cartItem.setQuantity(cartItem.getQuantity()+quantity);
		} else {
			// 沒有相同 id 則可以直接新增caetItem到cart中
			CartItem cartItem = new CartItem();
			cartItem.setCart(cart);          // 指向這ㄍ購物車
			cartItem.setItem(item);			 // 設定商品
			cartItem.setQuantity(quantity);  // 設定數量
			System.out.println(quantity   +"111111111112222222222222222");
		    cart.getCartItems().add(cartItem);    // cart 會自動對應 cartItem
		}
		
		
			cartRepository.save(cart);       // 然後一起存進資料庫
	}



	@Override
	public List<CartItem> getCartItem(Integer userId) {
		User user = userRepository.findById(userId)
					.orElseThrow(() -> new RuntimeException("使用者不存在"));
		
		Cart cart = cartRepository.findCartByUser(user);
		if(cart == null) {
			return new ArrayList<>();
		}
		cart.getCartItems().size(); // 強制初始化避免懶加載
		
		return cart.getCartItems();
	}
	
	
	
}
