package com.example.demo.aop;


// 驗證商品 ID 不可以是空ㄉ
// 商品數量要藉於 1~100 間
// 商品價格 > 0
public interface CartService {
	void addToCart(String productId, int quantity, Double price);
	
}
