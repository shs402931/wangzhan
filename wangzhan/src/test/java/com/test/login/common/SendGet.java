package com.test.login.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SendGet {

	//get请求的接口封装
	//param请求的参数复合 param=param   
	public String send(String url ,String param){
		String result="";
		String urlName = url +"?"+param;
		try{
			URL  realUrl = new URL(urlName);
			//打开和url的链接
			URLConnection conn =  realUrl.openConnection();
			//设置通用属性头
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
            //建立实际链接
            conn.connect();
            //获取URLConnection的响应内容getInputStream()  getOutputStream用于向URLConnection发送请求参数
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while((line =in.readLine())!=null){
            	result += line;
            }
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
