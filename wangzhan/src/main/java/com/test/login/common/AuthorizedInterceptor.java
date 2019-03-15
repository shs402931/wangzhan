package com.test.login.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.test.login.domain.Login;


public class AuthorizedInterceptor implements HandlerInterceptor {
	//定义不需要拦截的请求
	private static final String[] IGNORE_URI = {"/register","/login","/page"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub+
		//默认用户没有登录
		boolean flag = false;
		//获得请求的servletPath
		String  servletPath = request.getServletPath();
		//判断请求是否需要拦截
		for(String s : IGNORE_URI){
			if(servletPath.contains(s)){
				flag = true;
				break;
			}
		}
		//拦截请求
		if(!flag){
			//获取session中用户   setAttribute（）保存数据
			Login user = (Login)request.getSession().getAttribute("user");
			//判断用户是否登录
			if(user ==null){
				//如果用户没有登录，跳转登录页面       
				request.setAttribute("message", "请先登录");
				request.getRequestDispatcher("/html/login2.html").forward(request, response);
				return flag;
			}else{
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
