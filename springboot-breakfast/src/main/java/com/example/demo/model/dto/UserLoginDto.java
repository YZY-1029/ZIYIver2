package com.example.demo.model.dto;

import lombok.Data;

@Data
public class UserLoginDto {
	private String email;
	private String password;
//	private String recaptchaToken;
}
