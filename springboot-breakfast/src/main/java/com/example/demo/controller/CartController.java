package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.User;
import com.example.demo.service.CartService;
import com.example.demo.service.Impl.CartServiceImpl;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	 // 新增商品到購物車的 API
    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody CartDto request, HttpSession session) {
    	UserCert userCert = (UserCert)session.getAttribute("userCert");
    	if (userCert == null) {
    		return ResponseEntity.status(401).body("要先登入");
    	}
    	try {
            cartService.addItemToCart(userCert.getUserId(), request.getItemId(), request.getQuantity());
            return ResponseEntity.ok("商品成功加入購物車");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("錯誤：" + e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItem(HttpSession session) {
    	UserCert userCert = (UserCert) session.getAttribute("userCert");
    	
    	if(userCert == null) {
    		return ResponseEntity.status(401).build();
    	}
    	
    	List<CartItem> items = cartService.getCartItem(userCert.getUserId());
    	
		return ResponseEntity.ok(items);
    }
    
    
    
	
}
