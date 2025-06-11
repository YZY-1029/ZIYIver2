package com.example.demo;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.ShoppingService;
@SpringBootApplication
public class McpClient6060Application {

	public static void main(String[] args) {
		SpringApplication.run(McpClient6060Application.class, args);
	}

	@Bean
	public ToolCallbackProvider toolCallbackProvider(ShoppingService shoppingService) {
		return MethodToolCallbackProvider.builder().toolObjects(shoppingService).build();
	}
}
