package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.CartCheckOutDto;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.OrderTable;
import com.example.demo.service.CheckOut;
import com.example.demo.service.Impl.CheckOutImpl;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/checkout")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class CheckOutController {
	
	@Autowired
	private CheckOut checkOut;
	
	// 結帳
	@PostMapping
	public ResponseEntity<String> checkOut(@RequestBody CartCheckOutDto checkoutNote, HttpSession session ) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		if (userCert == null) {
    		return ResponseEntity.status(401).body("要先登入");
    	}
		try {
			checkOut.checkOut(session, checkoutNote.getNote());
			return ResponseEntity.ok("結帳成功~");
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("結帳失敗" + e.getMessage());
		}
	}
	
	
	// 從資料庫抓歷史記錄下來
	@GetMapping("/history")
	public List<OrderTable> getOrderHistory(HttpSession session) {
		return checkOut.getOrderHistory(session);
		
		
	}

}
