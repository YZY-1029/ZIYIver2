package com.example.demo.service;

import java.text.Format;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ChatMessage;

@Component // 注意讓元件可以讓service來管理
public class TimerPublisher {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	
	// 每秒鐘推送一次時間 room3
	@Scheduled(fixedRate = 1000) // 1000 ms
	public void sendTimeToRoom3() {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setFrom("電腦");
		chatMessage.setContent("現在時刻" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		// 發送
		messagingTemplate.convertAndSend("/topic/messages/room3", chatMessage);
		
	}
	
}
