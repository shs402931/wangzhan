package com.test.login.common;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	//在新的Excel中写入数据
	public static void main(String[] args){
		//第一步，创建一个workbook对应一个excel文件
		XSSFWorkbook workbook = new XSSFWorkbook();
        //第二部，在workbook中创建一个sheet对应excel中的sheet
        XSSFSheet sheet = workbook.createSheet("sheet1");
        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
        XSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        XSSFCell cell = row.createCell(3);
        cell.setCellValue("date");
        cell = row.createCell(4);
        cell.setCellValue("month");

        //将文件保存到指定的位置
        try {
            FileOutputStream fos = new FileOutputStream("E:/result.xlsx");
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
