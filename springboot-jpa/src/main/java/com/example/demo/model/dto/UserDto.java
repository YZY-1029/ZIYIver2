package com.example.demo.model.dto;

import lombok.Data;

// UserDto 對弈於 User Entity
// 屬性名稱可以與所對應ㄉ entity 不同

@Data
public class UserDto {
	
	private Integer userId;  // 使用者 id
	private String username; // 使用者名稱
	private String email; // 使用者 email
	private Boolean active; // 使用者啟動
	private String role; // 腳色權限
	
	
}
