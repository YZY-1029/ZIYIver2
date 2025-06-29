package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.AdminFilter;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<Filter> adminFilter() {
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>(); 
		registrationBean.setFilter(new AdminFilter());
		registrationBean.addUrlPatterns("/admin/*");
		registrationBean.setOrder(1);   // 過濾器的權級 , 假設有多個 filter 的話 , 數字越小ㄉ越優先處理
		return registrationBean;
	
	}
}
