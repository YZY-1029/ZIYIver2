package com.example.demo.service;


import java.util.Map;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
public class RecaptchaService {
	public static final String secretKey = "6LePW1orAAAAAJUE_GKcSq3tVL9JMvWgJgGKRuzB";
	public static final String verifyUrl = "https://www.google.com/recaptcha/api/siteverify";
	
	public boolean verify(String token) {
		RestTemplate restTemplate = new RestTemplate();
		
		// 建立表單參數
		Map<String, String> body = Map.of(
					"secret",secretKey,
					"response",token
				);
		
		// 設定 context-type
		HttpHeaders headers = new HttpHeaders(null);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// 包成 entity
		HttpEntity<Map<String, String>> request = new HttpEntity<Map<String,String>>(body, headers);
		// POST 請求
		ResponseEntity<Map> response = restTemplate.postForEntity(verifyUrl, request, Map.class); 
		// 回傳
		Map responseBody = response.getBody();
		return (boolean) responseBody.get("success");
		
	}
	
}
