package com.test.login.service;


import com.test.login.domain.Login;

public interface LoginService {
	//ע���û�
	void registeron(Login register);
	
	//�����û����������¼
	Login selecton(String name,String pass);
	
	//����name��phone��ѯ�ظ���
	Login selectinon(String name);
	
}
