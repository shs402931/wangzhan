package com.test.login.dao;

import org.apache.ibatis.jdbc.SQL;

import com.test.login.domain.Login;

public class LoginDynaSqlProvider {
	public String loginRegister(Login login){
		String sql = new SQL(){
			{
				INSERT_INTO("login");
				if(login.getName()!=null && !login.getName().equals("")){
					VALUES(" name ","#{name}");
				}
				if(login.getPass()!=null && !login.getPass().equals("")){
					VALUES(" pass ","#{pass}");
				}
				if(login.getBirthday()!=null && !login.getBirthday().equals("")){
					VALUES(" birthday ","#{birthday}");
				}
				if(login.getPhone()!=null && !login.getPhone().equals("")){
					VALUES(" phone ","#{phone}");
				}
			}
		}.toString();
		return sql;
	}
}
