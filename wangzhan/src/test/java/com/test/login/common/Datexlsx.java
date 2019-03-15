package com.test.login.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datexlsx {
	
	//���ؼ��м��е�����
	public String getData(int row , int cell,String filePath ){
		String result="";
		try{
			GetWorkbook wbk = new GetWorkbook();
			Workbook wb = wbk.wbook(filePath);
			//��ʼ������һ��excel
			Sheet sheet = wb.getSheetAt(0);
				
			//���������getFirstRowNum()��ȡ��һ������
			int rows = sheet.getFirstRowNum()+(row-1);
			//��ȡ����������
			Row roww = sheet.getRow(rows);
			if(roww !=null){
				//��ȡ�����ĵ�һ������
				int cells = roww.getFirstCellNum()+(cell-1);
				//��ȡ����������
				Cell cellc = roww.getCell(cells);
				result = cellc.toString();
			}else{
				result= "û������ ";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
