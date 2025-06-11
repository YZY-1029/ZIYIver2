package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CartDto;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	 // 新增商品到購物車的 API
    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody CartDto request) {
        try {
            cartService.addItemToCart(request.getUserId(), request.getItemId(), request.getQuantity());
            return ResponseEntity.ok("商品成功加入購物車");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("錯誤：" + e.getMessage());
        }
    }
	
	
}
