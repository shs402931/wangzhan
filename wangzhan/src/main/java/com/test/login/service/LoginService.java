package com.test.login.service;


import com.test.login.domain.Login;

public interface LoginService {
	//注册用户
	void registeron(Login register);
	
	//根据用户名和密码登录
	Login selecton(String name,String pass);
	
	//根据name和phone查询重复的
	Login selectinon(String name);
	
}
