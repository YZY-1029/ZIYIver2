package com.example.demo;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.service.LottoService;

@SpringBootApplication
public class McpServer9090Application {

    private final LottoService lottoService;

    McpServer9090Application(LottoService lottoService) {
        this.lottoService = lottoService;
    }

	public static void main(String[] args) {
		SpringApplication.run(McpServer9090Application.class, args);
	}
	@Bean
	public ToolCallbackProvider toolCallbackProvider(LottoService lottoService) {
		return MethodToolCallbackProvider.builder().toolObjects(lottoService).build();
	} 
}
