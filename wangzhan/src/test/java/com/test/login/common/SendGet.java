package com.test.login.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SendGet {

	//get����Ľӿڷ�װ
	//param����Ĳ������� param=param   
	public String send(String url ,String param){
		String result="";
		String urlName = url +"?"+param;
		try{
			URL  realUrl = new URL(urlName);
			//�򿪺�url������
			URLConnection conn =  realUrl.openConnection();
			//����ͨ������ͷ
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
            //����ʵ������
            conn.connect();
            //��ȡURLConnection����Ӧ����getInputStream()  getOutputStream������URLConnection�����������
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
