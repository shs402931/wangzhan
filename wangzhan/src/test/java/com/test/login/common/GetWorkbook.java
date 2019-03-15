package com.test.login.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetWorkbook {

	//��װ����excel��׺xls��xlsx�Ĺ�����
	public Workbook wbook(String filePath){
		Workbook wb =null;
		try{
			//�ļ�·��
			File excel = new File(filePath);
			//�ж��ļ��Ƿ����
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
