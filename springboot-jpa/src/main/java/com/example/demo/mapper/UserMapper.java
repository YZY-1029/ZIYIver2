package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.example.demo.model.dto.UserDto;

import com.example.demo.model.entity.User;

@Component
@Service
@Repository
public class UserMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDto toDto(User user) {
		// entity 轉 dto
		return modelMapper.map(user, UserDto.class);
	}
	
	public User toEntity(UserDto userDto) {
		// DTO 轉 Entity
		return modelMapper.map(userDto, User.class);
	}
	
	
}
