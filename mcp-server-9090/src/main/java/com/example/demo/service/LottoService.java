package com.example.demo.service;

import java.util.List;
import java.util.Random;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

// 這裡是一班ㄉ API
@Service
public class LottoService {
	
	/* 取得 金採539 的樂透號碼
	 * @param amount 購買數量
	 */
	@Tool(name = "lotto", description = "可以得到樂透電腦選號")
	public String lotto539(@ToolParam(description = "電腦選號數量或是張數")Integer amount) {
		Random random = new Random();
		return "LottoService 產生樂透號碼" + random.nextInt(10);  // 0~9
	}
	
	
	/* 樂透結帳
	 * @param amount 購買數量
	 */
	@Tool(name = "checkOut", description = "樂透結帳/付款,可以在選好樂透的組號跟數量之後進行結帳")
	public String checkout(@ToolParam(description = "要結帳的數量")Integer amount) {
		return "LottoService 樂透結帳:$" + amount * 50;
	}
}
