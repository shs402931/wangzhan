package com.test.login.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcel {

	public static void main(String[] args) throws IOException, InvalidFormatException{
		//excel文件路径
		String excelPath = "E:/ceshi.xlsx";
		File excel = new File(excelPath);
		//判断文件是否存在
		if(excel.isFile() && excel.exists()){
			//.是特殊字符，需要转义！！！！！
			String[] split = excel.getName().split("\\.");
			Workbook wb;//打开表的意思
			//根据文件后缀（xls/xlsx）进行判断
			if("xls".equals(split[1])){
				FileInputStream fis = new FileInputStream(excel);
				wb = new HSSFWorkbook(fis);
			}else if("xlsx".equals(split[1])){
				FileInputStream fis = new FileInputStream(excel);
				wb = new XSSFWorkbook(excel);
			}else{
				System.out.println("文件类型错误!");
                return;
			}
			//开始解析//读取sheet 0
			Sheet sheet = wb.getSheetAt(0);
			//第一行是列名，可以不读，也可以读取
			int  firstRowIndex = sheet.getFirstRowNum()+1;
			//读取最后一行
			int  lastRowIndex = sheet.getLastRowNum();
			//遍历行
			for(int rIndex = firstRowIndex ; rIndex<= lastRowIndex  ;rIndex++){
				 //获取行
				 Row  row = sheet.getRow(rIndex);
				 if(row !=null){
					 //获取第一个内容
					 int firstCellIndex = row.getFirstCellNum();
					 System.out.println(firstCellIndex );
					 //获取最后一个内容
					 int lastCellIndex = row.getLastCellNum();
					 System.out.println(lastCellIndex );
					 //遍历列
					 for(int cIndex =firstCellIndex; cIndex<=lastCellIndex ;cIndex++){
						 Cell cell = row.getCell(cIndex);
						 if(cell !=null ){
							 System.out.println(cell.toString());
						 }
					 }
				 }
			}			
		}else{
			System.out.println("找不到指定的文件");
		}
	}
}
