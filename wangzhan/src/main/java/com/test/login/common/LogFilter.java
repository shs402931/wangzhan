package com.test.login.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest servletRequest = (HttpServletRequest) request;
		 HttpServletResponse servletResponse = (HttpServletResponse) response;
		 HttpSession session = servletRequest.getSession();
		 String path = servletRequest.getRequestURI();
		 String empId = (String) session.getAttribute("user");
		 if(path.indexOf("/login2.html") > -1) {
			 chain.doFilter(servletRequest, servletResponse);
			 return;
		 }
		 if (empId == null || "".equals(empId)) {
			 servletResponse.sendRedirect("/html/login2.html");
		 }  else {
			  chain.doFilter(request, response);
		 }
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// 获取初始化参数
        String site = config.getInitParameter("Site");
     // 输出初始化参数
        System.out.println("网站名称: " + site);
	}

}
