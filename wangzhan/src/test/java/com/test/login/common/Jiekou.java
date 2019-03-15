package com.test.login.common;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Jiekou {

	public static void main(String[] args){
		String filePath = "E:/ceshi.xlsx";
		//获取总行数
		GetWorkbook wbk = new GetWorkbook();
		Workbook wb = wbk.wbook(filePath);
		Sheet sheet = wb.getSheetAt(0);
		//总行数
		int rowTotal = sheet.getLastRowNum()+1;
		//从第二行开始读取数据，封装的时候直接从几行几列算的所以+2
		int firstRow = sheet.getFirstRowNum()+2;
		//调用excel数据
		Datexlsx data = new Datexlsx();
		for(int i =firstRow ;i<=rowTotal;i++){
			for(int j=i;j<=i;j++){
				//获取url
				String url = data.getData(i, 3, filePath);
				System.out.println(url);
				//获取请求参数
				String param = data.getData(i, 4, filePath);
				System.out.println(param);
				//获取预期结果数据
				String results = data.getData(i, 5, filePath);
				System.out.println(results);
				//获取功能模块
				String resultss = data.getData(i, 2, filePath);
				//创建请求实例
				SendGet urlGet = new SendGet();
				String result = urlGet.send(url, param);
				System.out.println(result);
				if(results.equals(result)){
					System.out.println(resultss+":"+true+"\n");
				}else{
					System.out.println(resultss+":"+false+"\n");
				}
			}
		}

	}
}
