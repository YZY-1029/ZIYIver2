package com.example.demo.util;


import java.util.UUID;

import com.example.demo.model.dto.UserDto;

import lombok.Data;


// 這是可以當作有活動德時候,使用者的識別碼
@Data
public class Uuid {
	
	UserDto userDto = new UserDto();
	String uu = userDto.getUserName();
	
	private UUID uuid = UUID.nameUUIDFromBytes(uu.getBytes());
	
}
