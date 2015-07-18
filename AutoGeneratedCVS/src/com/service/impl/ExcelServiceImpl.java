package com.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.service.ExcelService;

public class ExcelServiceImpl implements ExcelService{

	private String sheetName = "template";
	private HSSFWorkbook hssfWb = null;
	private XSSFWorkbook xssfWb = null;
	private HSSFCellStyle cellStyle = null;
	public ExcelServiceImpl(){
		hssfWb = new HSSFWorkbook();
		xssfWb = new XSSFWorkbook();
	}

	public HSSFCellStyle getCellStyle() {
		return cellStyle;
	}
	public void setCellStyle(HSSFCellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}


	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	/**
	 * this method converts a xls(2003) file to a list
	 */
	public List<List> getRecordListFromXLS(FileInputStream fis,int index) {

		HSSFWorkbook hssfWbTmp = null;
		try {
			hssfWbTmp = new HSSFWorkbook(fis);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		HSSFSheet sheetTmp = hssfWbTmp.getSheetAt(index);
		List<List> result = new ArrayList<List>();
		int wbRows = sheetTmp.getLastRowNum();
		//at least,one row requested
		if(wbRows>=1){
			HSSFRow row = null;
			List listRow = new ArrayList();
			//gain title
			row = sheetTmp.getRow(0);
			int cellNum = row.getLastCellNum();
			for(int c = 0; c < cellNum;c++)
			{
				listRow.add(getCellValueXLS(row.getCell(c)));
			}
			result.add(listRow);
			//handle data row
			for(int r = 1; r <= wbRows; r++){
				ArrayList tmp = new ArrayList();
				for(int c = 0 ;c < cellNum ;c++){
					tmp.add("");
				}
				row = sheetTmp.getRow(r);
				for(int k = 0;k < cellNum;k++){
					tmp.set(k,getCellValueXLS(row.getCell(k)));
				}

				result.add(tmp);
			}

		}


		return result;
	}

	/**
	 * this method converts a xlsx(2007) file to a list
	 */
	public List<List> getRecordListFromXLSX(FileInputStream fis) {

		XSSFWorkbook xssfWbTmp = null;
		try {
			xssfWbTmp = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		XSSFSheet sheetTmp = xssfWbTmp.getSheetAt(0);
		List<List> result = new ArrayList<List>();
		int wbRows = sheetTmp.getLastRowNum();
		//at least,one row requested
		if(wbRows>=1){
			XSSFRow row = null;
			List listRow = new ArrayList();
			//gain title
			row = sheetTmp.getRow(0);
			int cellNum = row.getLastCellNum();
			for(int c = 0; c < cellNum;c++)
			{
				listRow.add(getCellValueXLSX(row.getCell(c)));
			}
			result.add(listRow);
			//handle data row
			for(int r = 1; r <= wbRows; r++){
				ArrayList tmp = new ArrayList();
				for(int c = 0 ;c < cellNum ;c++){
					tmp.add("");
				}
				row = sheetTmp.getRow(r);
				for(int k = 0;k < cellNum;k++){
					tmp.set(k,getCellValueXLSX(row.getCell(k)));
				}

				result.add(tmp);
			}

		}


		return result;
	}

	/**
	 * this method overloads getRecordListFromXLS(FileInputStream)
	 */
	public List<List> getRecordListFromXLS(String filePath,int index) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return null;
		}
		List listRet = getRecordListFromXLS(fis,index);
		try {
			if(fis != null)
				fis.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return listRet;
	}


	/**
	 * this method overloads getRecordListFromXLSX(FileInputStream)
	 */
	public List<List> getRecordListFromXLSX(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return null;
		}
		List listRet = getRecordListFromXLSX(fis);
		try {
			if(fis != null)
				fis.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return listRet;
	}
	/**
	 * export list to a excel 2003 file
	 */
	public HSSFWorkbook generateExcelFromList(List<List> list) {

		if(list != null && list.size()>0){
			if(hssfWb == null){
				hssfWb = new HSSFWorkbook();
			}
			HSSFSheet st = null;
			try{
				if("".equals(sheetName)){
					st = hssfWb.createSheet();
				}
				else{
					st = hssfWb.createSheet(sheetName);
				}
				//set title
				HSSFRow firstRow = st.createRow(0);
				setHeadRow(list,firstRow);
				for(int i = 1;i<list.size();i++){
					HSSFRow row = st.createRow(i);
					List listTmp = list.get(i);
					for(int j = 0;j<listTmp.size();j++){
						HSSFCell cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(listTmp.get(j).toString());
					}
				}
				return hssfWb;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}

		}
		return null;
	}

	/**
	 * export list to a excel 2007 file
	 */
	public XSSFWorkbook generateExcelXSSFromList(List<List> list) {

		if(list != null && list.size()>0){
			if(xssfWb == null){
				xssfWb = new XSSFWorkbook();
			}
			XSSFSheet st = null;
			try{
				if("".equals(sheetName)){
					st = xssfWb.createSheet();
				}
				else{
					st = xssfWb.createSheet(sheetName);
				}
				//set title
				XSSFRow firstRow = st.createRow(0);
				setXSSHeadRow(list,firstRow);
				for(int i = 1;i<list.size();i++){
					XSSFRow row = st.createRow(i);
					List listTmp = list.get(i);
					for(int j = 0;j<listTmp.size();j++){
						XSSFCell cell = row.createCell(j,XSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(listTmp.get(j).toString());
					}
				}
				return xssfWb;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}

		}
		return null;
	}
	/**
	 * write list to a excel 2007 file
	 */

	public void writeExcelXSSToFile(XSSFWorkbook wb,String filePath){
		FileOutputStream fos = null;

		if(wb == null || null == filePath || "".equals(filePath)){
			System.out.println("parameter is invalid");
			return;
		}
		File file = null;
		if(filePath.indexOf(".") != -1)
			file = new File(filePath);
		else
			file = new File(filePath+".xlsx");
		if(file.exists()){
			System.out.println("file exists,rename it");
			int fileNum = 1;
			String fileName = "";
			String fileSuffix = "";
			if(filePath.indexOf(".") != -1){
				fileName = filePath.substring(0, filePath.lastIndexOf("."));
				fileSuffix = filePath.substring(filePath.lastIndexOf("."));
				if(fileSuffix == null || "".equals(fileSuffix)){
					fileSuffix = "xlsx";
				}
			}
			else{
				fileName = filePath;
				fileSuffix = ".xlsx";
			}
			file = new File(fileName+"_"+fileNum+fileSuffix);
			while(file.exists()){
				fileNum ++;
				file = new File(fileName+"_"+fileNum+fileSuffix);
			}
		}
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return;
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public void writeExcelToFile(HSSFWorkbook wb,String filePath){
		FileOutputStream fos = null;

		if(wb == null || null == filePath || "".equals(filePath)){
			System.out.println("parameter is invalid");
			return;
		}
		File file = null;
		if(filePath.indexOf(".") != -1)
			file = new File(filePath);
		else
			file = new File(filePath+".xlsx");
		if(file.exists()){
			System.out.println("file exists,rename it");
			int fileNum = 1;
			String fileName = "";
			String fileSuffix = "";
			if(filePath.indexOf(".") != -1){
				fileName = filePath.substring(0, filePath.lastIndexOf("."));
				fileSuffix = filePath.substring(filePath.lastIndexOf("."));
				if(fileSuffix == null || "".equals(fileSuffix)){
					fileSuffix = "xlsx";
				}
			}
			else{
				fileName = filePath;
				fileSuffix = ".xlsx";
			}
			file = new File(fileName+"_"+fileNum+fileSuffix);
			while(file.exists()){
				fileNum ++;
				file = new File(fileName+"_"+fileNum+fileSuffix);
			}
		}
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return;
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}


	}
	/**
	 * create style of first row
	 * @param wb
	 * @return HSSFCellStyle
	 */
	private HSSFCellStyle createHeadStyle(){

		if(hssfWb == null){
			hssfWb = new HSSFWorkbook();
		}
		HSSFFont font = hssfWb.createFont();
		cellStyle = hssfWb.createCellStyle();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setFont(font);
		return cellStyle;
	}
	/**
	 * according by list,create the title of WB
	 * @param list
	 * @param firstRow
	 * @return
	 */
	private void setHeadRow(List<List> list,HSSFRow firstRow){

		if(list != null && list.size()>0){
			createHeadStyle();
			List headList = list.get(0);
			for(int i = 0;i < headList.size(); i++){
				HSSFCell cell = firstRow.createCell(i,HSSFCell.CELL_TYPE_STRING);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(headList.get(i).toString());
			}
		}
	}

	private void setXSSHeadRow(List<List> list,XSSFRow firstRow){
		if(xssfWb == null){
			xssfWb = new XSSFWorkbook();
		}
		Font font = xssfWb.createFont();
		CellStyle  xsscellStyle = xssfWb.createCellStyle();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		xsscellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		xsscellStyle.setFont(font);
		if(list != null && list.size()>0){
			//createHeadStyle();
			List headList = list.get(0);
			for(int i = 0;i < headList.size(); i++){
				XSSFCell cell = firstRow.createCell(i,XSSFCell.CELL_TYPE_STRING);
				cell.setCellStyle(xsscellStyle);
				cell.setCellValue(headList.get(i).toString());
			}
		}
	}

	/**
	 * get value from cells
	 * @param cell
	 * @return
	 */
	private String getCellValueXLS(HSSFCell cell) {
		if(cell == null){
			return "";
		}
		int type = cell.getCellType();
		String result = null;
		switch (type) {
		case HSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue() + "";
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			
			if (DateUtil.isCellDateFormatted(cell)) {
                Date theDate = cell.getDateCellValue();  
                
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
                result = simpleDateFormat.format(theDate);
			}else{
				double tmp = cell.getNumericCellValue();
				if ((tmp - (int) tmp) > 0) {
					result = cell.getNumericCellValue() + "";
				} else {
					result = (int) cell.getNumericCellValue() + "";
				}
			}
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			result = "";
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;
		default:
			result = "";
			break;
		}
		return result.trim();
	}
	/**
	 * get value from cell while style of excel file is XLSX
	 * @param cell
	 * @return
	 */
	private String getCellValueXLSX(XSSFCell cell)
	{
		if(cell == null)
			return "";
		int type = cell.getCellType();
		String result = null;
		switch(type)
		{
		case XSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue()+"";
			break;
		case XSSFCell.CELL_TYPE_NUMERIC:
			double tmp = cell.getNumericCellValue();
			if((tmp-(int)tmp)>0)
			{
				result = cell.getNumericCellValue()+"";
			}
			else
			{
				result = (int)cell.getNumericCellValue()+"";
			}
			break;
		case XSSFCell.CELL_TYPE_ERROR:
			result = "";
			break;
		case XSSFCell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;
		default:
			result = "";
			break;
		}

		return result.trim();
	}

	public static void main(String[] args) throws IOException{
		ExcelService excelService = new ExcelServiceImpl();
		List<List> result =  excelService.getRecordListFromXLS("c:\\wtchk_prod_storelocator_20130925.xls",0);
		List listTitle = result.get(0);
		
		//XSSFWorkbook hwb = excelService.generateExcelXSSFromList(result);

		//excelService.writeExcelXSSToFile(hwb, "c:\\test.csv");
		FileWriter fw  = new FileWriter("c:\\helloworld.csv");
		for(int i = 0;i< result.size();i++){
			List everyCell = result.get(i);
			StringBuffer str = new StringBuffer();
			for(int j = 0;j<everyCell.size();j++){
				str.append(everyCell.get(j)+"|");
				if( j == everyCell.size() -1){
					str.append("\r\n");
				}
			}
			fw.write(str.toString());
		    fw.flush();
		}
		fw.close();
		 
//		System.out.println("-----------------title-----------------------------");
//		for(int j = 0;j<listTitle.size();j++){
//			System.out.print(listTitle.get(j)+"|");
//		}
//		System.out.println("");
//		for(int i = 1; i< result.size();i++){
//			List tmpBody = result.get(i);
//			for(int k = 0;k<tmpBody.size();k++){
//				System.out.print(tmpBody.get(k)+"|");
//			}
//			System.out.print("\n");
//		}
		//List<List> resultX = excelService.getRecordListFromXLS("c:\\template.xlsx");
		//List listTitleX = resultX.get(0);

//		System.out.println("-----------------titleX-----------------------------");
//		for(int j = 0;j<listTitleX.size();j++){
//			System.out.print(listTitleX.get(j)+"|");
//		}
//		System.out.println("");
//		for(int i = 1; i< resultX.size();i++){
//			List tmpBody = resultX.get(i);
//			for(int k = 0;k<tmpBody.size();k++){
//				System.out.print(tmpBody.get(k)+"|");
//			}
//			System.out.print("\n");
//		}

//		List<List> list = new ArrayList<List>();
//		List list1 = new ArrayList();
//		list1.add("1");
//		list1.add("2");
//		list1.add("3");
//		list1.add("4");
//		list.add(list1);
		//XSSFWorkbook hwb = excelService.generateExcelXSSFromList(list);

		//excelService.writeExcelXSSToFile(hwb, "c:\\test.xlsx");

	}


}
