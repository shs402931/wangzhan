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
		//excel�ļ�·��
		String excelPath = "E:/ceshi.xlsx";
		File excel = new File(excelPath);
		//�ж��ļ��Ƿ����
		if(excel.isFile() && excel.exists()){
			//.�������ַ�����Ҫת�壡��������
			String[] split = excel.getName().split("\\.");
			Workbook wb;//�򿪱����˼
			//�����ļ���׺��xls/xlsx�������ж�
			if("xls".equals(split[1])){
				FileInputStream fis = new FileInputStream(excel);
				wb = new HSSFWorkbook(fis);
			}else if("xlsx".equals(split[1])){
				FileInputStream fis = new FileInputStream(excel);
				wb = new XSSFWorkbook(excel);
			}else{
				System.out.println("�ļ����ʹ���!");
                return;
			}
			//��ʼ����//��ȡsheet 0
			Sheet sheet = wb.getSheetAt(0);
			//��һ�������������Բ�����Ҳ���Զ�ȡ
			int  firstRowIndex = sheet.getFirstRowNum()+1;
			//��ȡ���һ��
			int  lastRowIndex = sheet.getLastRowNum();
			//������
			for(int rIndex = firstRowIndex ; rIndex<= lastRowIndex  ;rIndex++){
				 //��ȡ��
				 Row  row = sheet.getRow(rIndex);
				 if(row !=null){
					 //��ȡ��һ������
					 int firstCellIndex = row.getFirstCellNum();
					 System.out.println(firstCellIndex );
					 //��ȡ���һ������
					 int lastCellIndex = row.getLastCellNum();
					 System.out.println(lastCellIndex );
					 //������
					 for(int cIndex =firstCellIndex; cIndex<=lastCellIndex ;cIndex++){
						 Cell cell = row.getCell(cIndex);
						 if(cell !=null ){
							 System.out.println(cell.toString());
						 }
					 }
				 }
			}			
		}else{
			System.out.println("�Ҳ���ָ�����ļ�");
		}
	}
}
