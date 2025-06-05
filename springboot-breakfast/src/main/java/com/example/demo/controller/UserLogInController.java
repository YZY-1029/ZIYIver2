package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CertException;
import com.example.demo.model.dto.LoginRequest;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.CertService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;
import jdk.dynalink.linker.LinkRequest;



// 由這邊接受 http 請求, 然後呼叫 service 去進行使用者驗證, 成功後可以從 service 拿到憑證
@RestController
@RequestMapping("/log")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true" )   // 允許跨域
public class UserLogInController {
	
	@Autowired
	private CertService certService;
	
	
	@PostMapping("/in")
	public ResponseEntity<ApiResponse<Void>> login(@RequestBody UserLoginDto userEmail, HttpSession session){
		try {
			UserCert cert = certService.getCert(userEmail.getEmail(), userEmail.getPassword());
			session.setAttribute("userCert", cert);
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));
		} catch (CertException e) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(ApiResponse.error(401, "登入失敗" + e.getMessage()));
		}
	}
	
	@GetMapping("/out")
	public ResponseEntity<ApiResponse<Void>> logout(HttpSession session) {
		if(session.getAttribute("userCert") == null) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(ApiResponse.error(401, "登出失敗: 尚未登入"));
		}
		session.invalidate();
		return ResponseEntity.ok(ApiResponse.success("登出成功", null));
	}
	
	// 檢查是否登入中
	@GetMapping("/check")
	public ResponseEntity<ApiResponse<Boolean>> checkLog(HttpSession session) {
		boolean logged = session.getAttribute("userCert") !=null;
		return ResponseEntity.ok(ApiResponse.success("檢查登入", logged));
	}
	
}
