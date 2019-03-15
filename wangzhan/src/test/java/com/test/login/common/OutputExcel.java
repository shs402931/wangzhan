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

	//������Excel.xlsx��д������
	public static void main(String[] args){
		try{
			//��ȡE:/result.xlsx,�������ݵ�����ͨ��
			FileInputStream fileInputStream = new FileInputStream("E:/aa.xlsx");
			//ʹ��POI�ṩ�ķ����õ�excel����Ϣ
			OPCPackage poifsFileSystem=OPCPackage.open(fileInputStream);
			//�õ��ĵ�����
			 XSSFWorkbook Workbook=new XSSFWorkbook(poifsFileSystem);
			//����name��ȡsheet��
			 XSSFSheet sheet=Workbook.getSheet("sheet1");
			 //��ȡ��һ��
			 XSSFRow row=sheet.getRow(0);
			//��E:/result.xlsx��д����
			 FileOutputStream out=new FileOutputStream("E:/aa.xlsx");
			//����������4�����ǵ�������������
			 row=sheet.createRow((short)(sheet.getLastRowNum()-4));
			 row.createCell(0).setCellValue("������");
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
