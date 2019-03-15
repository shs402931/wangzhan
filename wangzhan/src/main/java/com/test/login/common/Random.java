package com.test.login.common;

public class Random {
	String code = "";
	public String getCode(){
		for(int i=0; i<6; i++){
			int random = (int)(Math.random()*10);
			code =code+random;
		}
		return code;
	}
	public void setCode(String code){
		this.code = code;
	}
}
