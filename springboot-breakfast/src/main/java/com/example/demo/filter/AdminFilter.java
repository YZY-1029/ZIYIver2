package com.example.demo.filter;

import com.example.demo.model.dto.UserCert;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		// 檢查 session 是否登入
		UserCert userCert = (UserCert) httpReq.getSession().getAttribute("userCert");
		
		if (userCert == null || !"admin".equals(userCert.getRole())) {
			httpRes.setStatus(HttpServletResponse.SC_FORBIDDEN);  // 403錯誤
			httpRes.getWriter().write("權限不足");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
