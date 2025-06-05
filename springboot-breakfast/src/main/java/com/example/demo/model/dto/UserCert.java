package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//使用者憑證
//登入成功之後會得到ㄉ憑證資料 ( 只有 Getter )  // 不給 data ( 因為 data 裡面有 getter 跟 setter 0
@AllArgsConstructor
@Getter
@ToString
public class UserCert {
	private Integer userId; // 使用者 Id
	private String username; // 使用者名稱
	private String role; // 角色權限
	
}
