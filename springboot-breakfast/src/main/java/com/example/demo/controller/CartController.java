package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CartDto;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.CartItem;

import com.example.demo.service.CartService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;





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
            return ResponseEntity.ok("商品"+request.getQuantity()+"個 成功加入購物車");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("錯誤：" + e.getMessage());
        }
    }
    // 顯示購物車資訊
    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItem(HttpSession session) {
    	UserCert userCert = (UserCert) session.getAttribute("userCert");
    	
    	if(userCert == null) {
    		return ResponseEntity.status(401).build();
    	}
    	
    	List<CartItem> items = cartService.getCartItem(userCert.getUserId());
    	
		return ResponseEntity.ok(items);
    }
    
    // 修改數量 +1
    @PostMapping("/update/plus")
    public ResponseEntity<String> updatePlusQuantity(@RequestBody CartDto request, HttpSession session) {
    	UserCert userCert = (UserCert)session.getAttribute("userCert");
    	if (userCert == null) {
    		return ResponseEntity.status(401).body("要先登入");
    	}
    	try {
            cartService.updatePlusQuantity(userCert.getUserId(), request.getItemId(), request.getQuantity());
            return ResponseEntity.ok("商品成功修改");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("修改失敗：" + e.getMessage());
        }
    }
    
    // 修改數量 -1
    @PostMapping("/update/min")
    public ResponseEntity<String> updateMinQuantity(@RequestBody CartDto request, HttpSession session) {
    	UserCert userCert = (UserCert)session.getAttribute("userCert");
    	if (userCert == null) {
    		return ResponseEntity.status(401).body("要先登入");
    	}
    	else if(request.getQuantity()>1){
	    	try {
	            cartService.updateMinQuantity(userCert.getUserId(), request.getItemId(), request.getQuantity());
	            return ResponseEntity.ok("商品成功修改");
	        } catch (RuntimeException e) {
	            return ResponseEntity.badRequest().body("修改失敗：" + e.getMessage());
	        }
    	}
		return null;
    }
    
    
    // 清除該商品
    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Integer itemId, HttpSession session) {
    	UserCert userCert = (UserCert) session.getAttribute("userCert");
    	if(userCert == null) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("請先登入");
    	}
    	Integer userId = userCert.getUserId();
    	
    	try {
    		cartService.deleteCartItem(userId, itemId);
    		return ResponseEntity.ok("刪除成功");
    	}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body("刪除失敗"+ e.getMessage());
		}
    }
    
    
    
	
}
