package com.service;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelService {
	public List<List> getRecordListFromXLS(FileInputStream fis,int index);
	public List<List> getRecordListFromXLSX(FileInputStream fis);
	public HSSFWorkbook generateExcelFromList(List<List> list);
	public List<List> getRecordListFromXLS(String filePath,int index);
	public List<List> getRecordListFromXLSX(String filePath);
	XSSFWorkbook generateExcelXSSFromList(List<List> list);
}
