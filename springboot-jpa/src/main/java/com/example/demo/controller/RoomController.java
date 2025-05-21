package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exception.RoomException;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.service.RoomService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Method URI            功能
 * --------------------------------------------------------------------
 * GET    /rooms                查詢所有會議室(多筆)
 * GET    /room/{roomId}        查詢指定會議室(單筆)
 * POST   /room                 新增會議室
 * POST   /room/update/{roomId} 完整修改會議室(同時修改 roomName 與 roomSize)
 * GET    /room/delete/{roomId} 刪除會議室
 * --------------------------------------------------------------------
 * */

@Controller
@RequestMapping(value = {"/room", "/rooms"})
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public String getRooms(Model model, @ModelAttribute RoomDto roomDto) { // 不想建立初始值的話可以用 @ModelAttribute(可寫可不寫) RoomDto roomDto
		//RoomDto roomDto = new RoomDto();
		List<RoomDto> roomDtos = roomService.findAllRooms();    // 因為 findAllRooms() 的傳回型態是 List<RoomDto> 所以 roomDtos 的型態也是 List<RoomDto> 
		//model.addAttribute("roomDto", roomDto);
		model.addAttribute("roomDtos", roomDtos);
		return "room/room";
	}
	
	
	/*
	 * @Valid RoomDto roomDto, BindingResult bindingResult
	 * RoomDto 要進行屬性資料驗證, 驗證結果收到bindResult
	 */
	@PostMapping
	public String addRoom(@Valid RoomDto roomDto, BindingResult bindingResult, Model model) {  // @ModelAttribute可寫可不寫  @Valid代表需要被驗證
		// 驗證資料
		if (bindingResult.hasErrors()) { // 諾驗證時有錯誤發生
			model.addAttribute("roomDtos", roomService.findAllRooms());
			return "room/room";
		}
		
		// 進行新增
		roomService.addRoom(roomDto);
		return "redirect:/rooms";
	}
	
	@GetMapping("/{roomId}")
	public String getRoom(@PathVariable Integer roomId, Model model) {
		RoomDto roomDto = roomService.getRoomById(roomId);
		model.addAttribute("roomDto",roomDto);
		return "room/room_update";
	}
	
	@PutMapping("/update/{roomId}")
	public String updateRoom(@PathVariable Integer roomId, @Valid RoomDto roomDto, BindingResult bindingResult) {
		// 驗證資料
				if (bindingResult.hasErrors()) { // 諾驗證時有錯誤發生
					
					return "room/room_update";
				}
				
				// 進行新增
				roomService.updateRoom(roomId, roomDto);
				return "redirect:/rooms";
	}
	
	
	 @DeleteMapping("/delete/{roomId}")
	 public String deleteRoom(@PathVariable Integer roomId) {
		roomService.deleteRoom(roomId); 
	 	return "room/room";
	 }
	 
	 
	@ExceptionHandler({RoomException.class})
	public String handleException(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("message",  e.getMessage());
		return "error";
	}
	
	
	
	
	
	
}