package com.test.login.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DataTest {

	//封装直接读取文件
	public List<String> testData(String filePath) {
		ArrayList<String> list = new ArrayList<>();
		Datexlsx data = new Datexlsx();
		GetWorkbook wbk = new GetWorkbook();
		Workbook wb = wbk.wbook(filePath);
		Sheet sheet = wb.getSheetAt(0);
		//获取总行数
		int row = sheet.getLastRowNum()+1;
		for(int i =2 ;i<=row;i++){
			 list.add(data.getData(i, 1,filePath));
			System.out.print(list.get(i-2) +"  ");
		}
		System.out.print("\n");
		return list;
	}
	public static void main(String[] args){
		DataTest dt = new DataTest();
		List<String> dd = dt.testData("E:/ceshi.xlsx");
		GetWorkbook wbk = new GetWorkbook();
		Workbook wb = wbk.wbook("E:/ceshi.xlsx");
		Sheet sheet = wb.getSheetAt(0);
		//获取总行数
		int row = sheet.getLastRowNum()+1;
		for(int i =2 ;i<=row;i++){
			System.out.print(dd.get(i-2)+"  ");
		}
	}

}
