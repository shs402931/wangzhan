package com.test.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.login.dao.LoginDao;
import com.test.login.domain.Login;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public void registeron(Login register) {
		// TODO Auto-generated method stub
		loginDao.register(register);		
	}

	//�����û����������¼
	@Override
	public Login selecton(String name, String pass) {
		// TODO Auto-generated method stub
		return loginDao.select(name, pass);
	}

	//����name��phone��ѯ�ظ���
	@Override
	public Login selectinon(String name) {
		// TODO Auto-generated method stub
		return loginDao.selectin(name);
	}

	
}
