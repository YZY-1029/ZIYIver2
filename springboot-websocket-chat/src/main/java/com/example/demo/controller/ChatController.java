package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.ChatMessage;

// 可以用來處理 WebSocket 聊天訊息: 支援多聊天室, 根據 roomId 可以廣播到不同離天室
@Controller
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate messageingTemplate; // 訊息範本
	
	/*
	 * 這邊可以處裡來自 "/app/chat/{roomId}" ㄉ訊息 並將訊息廣播到 "/topic/message/{roomId}"
	 * @param roomId 聊天室 Id
	 * @param chatMessage 聊天訊息
	 */
	
	@MessageMapping("/chat/{roomId}")
	public void send(@DestinationVariable String roomId, ChatMessage chatMessage) {
		messageingTemplate.convertAndSend("/topic/messages/" + roomId, chatMessage);
	}
	
	
	/*
	 * 這邊可以處裡來自 "/app/broadcast" ㄉ訊息 並將訊息廣播到 "/topic/broadcast" (所有聊天室)
	 * @param chatMessage 聊天訊息
	 */
	@MessageMapping("/broadcast")
	public void broadcast(ChatMessage chatMessage) {
		messageingTemplate.convertAndSend("/topic/broadcast", chatMessage);
	}
}
