package com.example.demo.service;


import java.util.List;

import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.OrderTable;

import jakarta.servlet.http.HttpSession;



public interface CheckOut {

	public List<CartItem> checkOut(HttpSession session);

	public List<OrderTable> getOrderHistory(HttpSession sessionn);
}


