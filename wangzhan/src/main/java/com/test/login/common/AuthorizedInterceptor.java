package com.test.login.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.test.login.domain.Login;


public class AuthorizedInterceptor implements HandlerInterceptor {
	//���岻��Ҫ���ص�����
	private static final String[] IGNORE_URI = {"/register","/login","/page"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub+
		//Ĭ���û�û�е�¼
		boolean flag = false;
		//��������servletPath
		String  servletPath = request.getServletPath();
		//�ж������Ƿ���Ҫ����
		for(String s : IGNORE_URI){
			if(servletPath.contains(s)){
				flag = true;
				break;
			}
		}
		//��������
		if(!flag){
			//��ȡsession���û�   setAttribute������������
			Login user = (Login)request.getSession().getAttribute("user");
			//�ж��û��Ƿ��¼
			if(user ==null){
				//����û�û�е�¼����ת��¼ҳ��       
				request.setAttribute("message", "���ȵ�¼");
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
