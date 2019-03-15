package com.test.login.common;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	//���µ�Excel��д������
	public static void main(String[] args){
		//��һ��������һ��workbook��Ӧһ��excel�ļ�
		XSSFWorkbook workbook = new XSSFWorkbook();
        //�ڶ�������workbook�д���һ��sheet��Ӧexcel�е�sheet
        XSSFSheet sheet = workbook.createSheet("sheet1");
        //����������sheet������ӱ�ͷ��0�У��ϰ汾��poi��sheet������������
        XSSFRow row = sheet.createRow(0);
        //���Ĳ���������Ԫ�����ñ�ͷ
        XSSFCell cell = row.createCell(3);
        cell.setCellValue("date");
        cell = row.createCell(4);
        cell.setCellValue("month");

        //���ļ����浽ָ����λ��
        try {
            FileOutputStream fos = new FileOutputStream("E:/result.xlsx");
            workbook.write(fos);
            System.out.println("д��ɹ�");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
