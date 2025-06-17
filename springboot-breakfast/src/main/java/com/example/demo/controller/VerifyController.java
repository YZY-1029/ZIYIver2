package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/verify")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class VerifyController {
	
	@Autowired
	private UserService userService;
	
	// 網址頁面
	@GetMapping("/confirm")
	public ResponseEntity<String> confirmEmail(@RequestParam String userName) {
		
		boolean result = userService.emailConfirmOk(userName);
		
		if (result) {
			return ResponseEntity.ok("驗證成功,");
		} else {
			return ResponseEntity.badRequest().body("驗證失敗,帳號已啟用或無此帳號");
		}
	}

}
