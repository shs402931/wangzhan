package com.test.login.common;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Jiekou {

	public static void main(String[] args){
		String filePath = "E:/ceshi.xlsx";
		//��ȡ������
		GetWorkbook wbk = new GetWorkbook();
		Workbook wb = wbk.wbook(filePath);
		Sheet sheet = wb.getSheetAt(0);
		//������
		int rowTotal = sheet.getLastRowNum()+1;
		//�ӵڶ��п�ʼ��ȡ���ݣ���װ��ʱ��ֱ�ӴӼ��м����������+2
		int firstRow = sheet.getFirstRowNum()+2;
		//����excel����
		Datexlsx data = new Datexlsx();
		for(int i =firstRow ;i<=rowTotal;i++){
			for(int j=i;j<=i;j++){
				//��ȡurl
				String url = data.getData(i, 3, filePath);
				System.out.println(url);
				//��ȡ�������
				String param = data.getData(i, 4, filePath);
				System.out.println(param);
				//��ȡԤ�ڽ������
				String results = data.getData(i, 5, filePath);
				System.out.println(results);
				//��ȡ����ģ��
				String resultss = data.getData(i, 2, filePath);
				//��������ʵ��
				SendGet urlGet = new SendGet();
				String result = urlGet.send(url, param);
				System.out.println(result);
				if(results.equals(result)){
					System.out.println(resultss+":"+true+"\n");
				}else{
					System.out.println(resultss+":"+false+"\n");
				}
			}
		}

	}
}
