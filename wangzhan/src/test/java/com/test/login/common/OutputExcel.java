package com.test.login.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutputExcel {

	//在已有Excel.xlsx中写入数据
	public static void main(String[] args){
		try{
			//获取E:/result.xlsx,建立数据的输入通道
			FileInputStream fileInputStream = new FileInputStream("E:/aa.xlsx");
			//使用POI提供的方法得到excel的信息
			OPCPackage poifsFileSystem=OPCPackage.open(fileInputStream);
			//得到文档对象
			 XSSFWorkbook Workbook=new XSSFWorkbook(poifsFileSystem);
			//根据name获取sheet表
			 XSSFSheet sheet=Workbook.getSheet("sheet1");
			 //获取第一行
			 XSSFRow row=sheet.getRow(0);
			//向E:/result.xlsx中写数据
			 FileOutputStream out=new FileOutputStream("E:/aa.xlsx");
			//对总行数减4，就是倒数行数加数据
			 row=sheet.createRow((short)(sheet.getLastRowNum()-4));
			 row.createCell(0).setCellValue("我叔叔");
			 row.createCell(5).setCellValue(11111);
			 
			 out.flush();
		     Workbook.write(out);
		     out.close();
		     System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
