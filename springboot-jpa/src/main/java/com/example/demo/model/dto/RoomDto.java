package com.example.demo.model.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
	@NotNull(message = "{roomDto.roomId.notNull}")
	@Range(min = 1, max = 9999, message = "{roomDto.roomId.range}") 
	private Integer roomId;
	
	@NotNull(message = "{roomDto.roomName.notEmpty}")  // 因為是 String 所以是 notEmpty
	@Size(min = 2, message = "{roomDto.roomName.size}")  // 因為是 String 所以是 Size
	private String roomName;
	
	@NotNull(message = "{roomDto.roomSize.notNull}")				   // 因為是 Integer 所以是 notnull
	@Range(min = 1, max = 500, message = "{roomDto.roomSize.range}") // 因為是 Integer 所以是 Range
	private Integer roomSize;
	
	
	
}
