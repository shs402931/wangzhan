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
	
	//返回几行几列的数据
	public String getData(int row , int cell,String filePath ){
		String result="";
		try{
			GetWorkbook wbk = new GetWorkbook();
			Workbook wb = wbk.wbook(filePath);
			//开始解析第一个excel
			Sheet sheet = wb.getSheetAt(0);
				
			//传入的行数getFirstRowNum()获取第一行数字
			int rows = sheet.getFirstRowNum()+(row-1);
			//获取行数的数据
			Row roww = sheet.getRow(rows);
			if(roww !=null){
				//获取行数的第一列数字
				int cells = roww.getFirstCellNum()+(cell-1);
				//获取列数的数据
				Cell cellc = roww.getCell(cells);
				result = cellc.toString();
			}else{
				result= "没有数据 ";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
