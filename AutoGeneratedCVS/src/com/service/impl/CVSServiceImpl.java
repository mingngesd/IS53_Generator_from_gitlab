package com.service.impl;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.service.CVSService;
import com.service.ExcelService;

public class CVSServiceImpl implements CVSService {

	public void writeListToCVSFile(List list, String filePath)throws IOException {
//		FileWriter fw = new FileWriter(filePath);
		 FileOutputStream fis=new FileOutputStream(filePath);     
		 OutputStreamWriter fw=new OutputStreamWriter(fis,"UTF-8"); 
		for (int i = 0; i < list.size(); i++) {
			String everyRow = (String)list.get(i);
			fw.write(everyRow.toString());
			fw.flush();
		}
		fw.close();
	}

	public static void main(String[] args) throws IOException {
		CVSServiceImpl cvs = new CVSServiceImpl();
		ExcelService excelService = new ExcelServiceImpl();
		List<List> result = excelService.getRecordListFromXLS("c:\\wtchk_prod_storelocator_20141030.xls",0);
		cvs.writeListToCVSFile(result,"C:\\helloworld.csv");
	}

}
