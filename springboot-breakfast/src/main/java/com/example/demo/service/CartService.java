package com.example.demo.service;

import java.util.List;

import com.example.demo.model.entity.CartItem;

public interface CartService {
	
	public void addItemToCart(Integer userId, Integer itemId, Integer quantity) ;
	
	public List<CartItem> getCartItem(Integer userId);
	
	public void updatePlusQuantity(Integer userId, Integer itemId, Integer quantity);
	
	public void updateMinQuantity(Integer userId, Integer itemId, Integer quantity);
	
	public void deleteCartItem(Integer userId, Integer itemId);
}
