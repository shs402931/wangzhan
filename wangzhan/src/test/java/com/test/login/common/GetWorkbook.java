package com.test.login.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetWorkbook {

	//封装返回excel后缀xls或xlsx的工作簿
	public Workbook wbook(String filePath){
		Workbook wb =null;
		try{
			//文件路径
			File excel = new File(filePath);
			//判断文件是否存在
			if(excel.isFile() && excel.exists()){
				String[] split = excel.getName().split("\\.");
				if("xls".equals(split[1])){
					FileInputStream fis = new FileInputStream(excel);
					wb =  new HSSFWorkbook(fis);
				}else if("xlsx".equals(split[1])){
					FileInputStream fis = new FileInputStream(excel);
					wb = new XSSFWorkbook(excel);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return wb;
	}
}
