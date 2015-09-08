package com.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class AutoGenergatedMain extends AutoGenergate{
	ExcelServiceImpl excelServiceImpl;
	CVSServiceImpl cvsServiceImpl;

	
	public AutoGenergatedMain(){
		excelServiceImpl = new ExcelServiceImpl();
		cvsServiceImpl = new CVSServiceImpl();
	}
	
	public List<List> readSheet1Excel(String path){
		String fi = path;
		List<List> result =  excelServiceImpl.getRecordListFromXLS(fi,0);
		return result;
	}
	
	public List<List> readSheet2Excel(String path){
		String fi = path;
		List<List> result =  excelServiceImpl.getRecordListFromXLS(fi,1);
		return result;
	}
	
	public void parseExcelEn(List<List> result){
		for(int i = 1;i<result.size();i++){
			List everyCell = result.get(i);
			for(int j = 0;j<everyCell.size();j++){
				try{
					genergateEn(everyCell,j,"en");
				}catch(Exception e){
					System.out.println("---"+" Error: "+(i+1)+"  row "+":"+(j+1)+" column "+"---"+e.getMessage());
				}
			}
			eachlist.add(getEachRow());
			reSetParam();
		}
	}
	
	public void parseExcelZt(List<List> result){
		for(int i = 1;i<result.size();i++){
			List everyCell = result.get(i);
			
			for(int j = 0;j<everyCell.size();j++){
				try{
					genergateChin(everyCell,j,"zt");
				}catch(Exception e){
				}
				
			}
			eachlist.add(getEachRow());
			reSetParam();
		}
	}
	
	public void parseExcelZh(List<List> result){
		for(int i = 1;i<result.size();i++){
			List everyCell = result.get(i);
			
			for(int j = 0;j<everyCell.size();j++){
				try{
					genergateChin(everyCell,j,"zh");
				}catch(Exception e){
				}
			}
			eachlist.add(getEachRow());
			reSetParam();
		}
	}
	
	public List parseExcel(List<List> result){
		parseExcelEn(result);
		parseExcelZt(result);
		parseExcelZh(result);
		//eachlist.add("\r\n");
		return eachlist;
	}
	
	public void toList(List<List> result){
		for(int i = 1;i<result.size();i++){
			List everyCell = result.get(i);
			for(int j = 0;j<everyCell.size();j++){
				String en = (String)everyCell.get(0);
				String zt = (String)everyCell.get(1);
				String zh = (String)everyCell.get(2);
				if(!en.trim().equals("") && j == 0)enWord.add(everyCell.get(0));
				if(!zt.trim().equals("") && j == 1)ztWord.add(everyCell.get(1));
				if(!zh.trim().equals("") && j == 2)zhWord.add(everyCell.get(2));
			}
		}
	}
	
	/*genergate en start*/
	public void genergateEn(List everyCell,int j,String lang) {
		if(j == 0){//编码POSITION_POS_CODE 和 语言编码POSITION_LANG_CODE
			/*
			position_pos_code = (String) everyCell.get(0);
			position_pos_code = "3".concat(position_pos_code.trim());
			*/
			position_lang_code =lang;
		}
		
		if(j ==8){//名称POSITION_POS_NAME
			position_pos_name = (String) everyCell.get(8);
		}
		
		if(j ==12){//街道名POSITION_STREET_NAME
			String strDes = (String) everyCell.get(12);
			strDes = strDes.replace("?", "");
			String[] test =  strDes.split(",");
			for(int k =0;k<test.length;k++){
				if(test.length > 2&& k < test.length -2){
					position_street_name = position_street_name + test[k]+",";
				}else if(test.length  <= 2){
					position_street_name = position_street_name +test[0]+",";
				}
			}
			position_street_name = position_street_name.substring(0,position_street_name.length()-1);
		}
		
		if(j == 3){//镇POSITION_TOWN
			position_town = position_town +(String) everyCell.get(3);
		}
		
		if(j ==6){//镇POSITION_TOWN
			position_town = (String) everyCell.get(6) +", "+position_town;
		}
		
		if(j ==6){//地区POSITION_DISTRICT
			position_district = (String) everyCell.get(6);
		}
				
		if(j ==1){//国家POSITION_COUNTRY
			position_country = (String) everyCell.get(1);
		}
		
		if(j ==3){//范围POSITION_REGION
			position_region = (String) everyCell.get(3);
		}
		
		if(j ==12){//地址2 POSITION_ADDRESS_LINE_2
			position_address_line_2 = (String) everyCell.get(12);
			position_address_line_2 = position_address_line_2.replace("?", "");
		}
				 
		if(j==18){//纬度POSITION_LATITUDE
			position_latitude = (String) everyCell.get(18);
		}
		
		if(j ==19){//经度POSITION_LONGITUDE
			position_logitude = (String) everyCell.get(19);
		}
		
		
		if(j ==23){//GENSTOREHOURS1
			String genstorehoursl = (String) everyCell.get(23);
			if(!genstorehoursl.equals("")){
				setGenstorehours(genstorehoursl);
			}
		}
		if(j ==24){//GENSTOREHOURS2
			String genstorehours2 = (String) everyCell.get(24);
			if(!genstorehours2.equals("")){
				setGenstorehours(genstorehours2);
			}
			
		}
		if(j ==25){//GENSTOREHOURS3
			String genstorehours3 = (String) everyCell.get(25);
			if(!genstorehours3.equals("")){
				setGenstorehours(genstorehours3);
			}
		}
		if(j ==26){//GENSTOREHOURS4
			String genstorehours4 = (String) everyCell.get(26);
			if(!genstorehours4.equals("")){
				setGenstorehours(genstorehours4);
			}
		}
		if(j ==27){//GENSTOREHOURS5
			String genstorehours5 = (String) everyCell.get(27);
			if(!genstorehours5.equals("")){
				setGenstorehours(genstorehours5);
			}
		}
		if(j ==28){//GENSTOREHOURS6
			String genstorehours6 = (String) everyCell.get(28);
			if(!genstorehours6.equals("")){
				setGenstorehours(genstorehours6);
			}
		}
		if(j ==29){//GENSTOREHOURS7
			String genstorehours7 = (String) everyCell.get(29);
			if(!genstorehours7.equals("")){
				setGenstorehours(genstorehours7);
			}
		}
		
		if(j ==31){//PHARMACYHOURS1
			String pharmacyhours1 = (String) everyCell.get(31);
			if(!pharmacyhours1.equals("")){
				pharmacyhours ="^P";
				setPharmacyhours(pharmacyhours1);
			}
		}
		if(j ==32){//PHARMACYHOURS2
			String pharmacyhours2 = (String) everyCell.get(32);
			if(!pharmacyhours2.equals("")){
				setPharmacyhours(pharmacyhours2);
			}
		}
		if(j ==33){//PHARMACYHOURS3
			String pharmacyhours3 = (String) everyCell.get(33);
			if(!pharmacyhours3.equals("")){
				setPharmacyhours(pharmacyhours3);
			}
		}
		if(j ==34){//PHARMACYHOURS4
			String pharmacyhours4 = (String) everyCell.get(34);
			if(!pharmacyhours4.equals("")){
				setPharmacyhours(pharmacyhours4);
			}
		}
		if(j ==35){//PHARMACYHOURS5
			String pharmacyhours5 = (String) everyCell.get(35);
			if(!pharmacyhours5.equals("")){
				setPharmacyhours(pharmacyhours5);
			}
		}
		if(j ==36){//PHARMACYHOURS6
			String pharmacyhours6 = (String) everyCell.get(36);
			if(!pharmacyhours6.equals("")){
				setPharmacyhours(pharmacyhours6);
			}
		}
		if(j ==37){//PHARMACYHOURS7
			String pharmacyhours7 = (String) everyCell.get(37);
			if(!pharmacyhours7.equals("")){
				setPharmacyhours(pharmacyhours7);
			}
		}
		
		//TODO how to add P remark and hotline
		if(j ==38){//PHARMACY Remark
			String pharmacyRemark = (String) everyCell.get(38);
		
			if(!pharmacyRemark.equals("")){
				if(!getPharmacyhours().contains("^P"))
					pharmacyhours ="^P";
				setPharmacyhours(pharmacyRemark);
			}
		}
		if(j ==39){//PHARMACY Hotline
			String pharmacyHotline = (String) everyCell.get(39);
			if(!pharmacyHotline.equals("")){
				if(!getPharmacyhours().contains("^P"))
					pharmacyhours ="^P";
				setPharmacyhours(pharmacyHotline);
			}
		}
		//TODO how to add N remark and hotline
		
		if(j ==40){//NUTRITION Remark
			String nutritionRemark = (String) everyCell.get(40);
			if(!nutritionRemark.equals("")){
				if(!getNutritionhours().contains("^N"))
					nutritionhours ="^N";
				setNutritionhours(nutritionRemark);
			}
		}
		if(j ==41){//NUTRITION Hotline
			String nutritionHotline = (String) everyCell.get(41);
			if(!nutritionHotline.equals("")){
				if(!getNutritionhours().contains("^N"))
					nutritionhours ="^N";
				setNutritionhours(nutritionHotline);
			}
		}
		
		
		if(j ==42){//CHIMEDHOURS1
			String chimedhours1 = (String) everyCell.get(42);
			if(!chimedhours1.equals("")){
				chimedhours ="^C";
				setChimedhours(chimedhours1);
			}
		}
		if(j ==43){//CHIMEDHOURS2
			String chimedhours2 = (String) everyCell.get(43);
			if(!chimedhours2.equals("")){
				setChimedhours(chimedhours2);
			}
		}
		if(j ==44){//CHIMEDHOURS3
			String chimedhours3 = (String) everyCell.get(44);
			if(!chimedhours3.equals("")){
				setChimedhours(chimedhours3);
			}
		}
		if(j ==45){//CHIMEDHOURS4
			String chimedhours4 = (String) everyCell.get(45);
			if(!chimedhours4.equals("")){
				setChimedhours(chimedhours4);
			}
		}
		if(j ==46){//CHIMEDHOURS5
			String chimedhours5 = (String) everyCell.get(46);
			if(!chimedhours5.equals("")){
				setChimedhours(chimedhours5);
			}
		}
		if(j ==47){//CHIMEDHOURS6
			String chimedhours6 = (String) everyCell.get(47);
			if(!chimedhours6.equals("")){
				setChimedhours(chimedhours6);
			}
		}
		if(j ==48){//CHIMEDHOURS7
			String chimedhours7 = (String) everyCell.get(48);
			if(!chimedhours7.equals("")){
				setChimedhours(chimedhours7);
			}
		}
		if(j ==49){//CHIMED Remark
			String chimedRemark = (String) everyCell.get(49);
			if(!chimedRemark.equals("")){
				if(!getChimedhours().contains("^C"))
					chimedhours ="^C";
				setChimedhours(chimedRemark);
			}
		}
		if(j ==50){//CHIMED Hotline
			String chimedHotline = (String) everyCell.get(50);
			if(!chimedHotline.equals("")){
				if(!getChimedhours().contains("^C"))
					chimedhours ="^C";
				setChimedhours(chimedHotline);
			}
		}
		
		
		String storeType = (String) everyCell.get(55);
		storeType=storeType.trim();
		
		if(j ==57){//STOREHOURS1
			String storehours1 = (String) everyCell.get(57);
			
			if(!storehours1.equals("")){
				if(storeType.equals("2")){
					babyHours ="^B";
					setBabyHours(storehours1);
				}else if(storeType.equals("3")){
					beautyHours ="^T";
					setBeautyHours(storehours1);
				}
			}
		}
		if(j ==58){//STOREHOURS2
			String storehours2 = (String) everyCell.get(58);
			
			if(!storehours2.equals("")){
				if(storeType.equals("2")){
					setBabyHours(storehours2);
				}else if(storeType.equals("3")){
					setBeautyHours(storehours2);
				}
			}
		}
		if(j ==59){//STOREHOURS3
			String storehours3 = (String) everyCell.get(59);
			
			if(!storehours3.equals("")){
				if(storeType.equals("2")){
					setBabyHours(storehours3);
				}else if(storeType.equals("3")){
					setBeautyHours(storehours3);
				}
			}
		}
		if(j ==60){//STOREHOURS4
			String storehours4 = (String) everyCell.get(60);
			
			if(!storehours4.equals("")){
				if(storeType.equals("2")){
					setBabyHours(storehours4);
				}else if(storeType.equals("3")){
					setBeautyHours(storehours4);
				}
			}
		}
		if(j ==61){//STOREHOURS5
			String storehours5 = (String) everyCell.get(61);
			
			if(!storehours5.equals("")){
				if(storeType.equals("2")){
					setBabyHours(storehours5);
				}else if(storeType.equals("3")){
					setBeautyHours(storehours5);
				}
			}
		}
		if(j ==62){//STOREHOURS6
			String storehours6 = (String) everyCell.get(62);
			
			if(!storehours6.equals("")){
				if(storeType.equals("2")){
					setBabyHours(storehours6);
				}else if(storeType.equals("3")){
					setBeautyHours(storehours6);
				}
			}
		}
		if(j ==63){//STOREHOURS7
			String storehours7 = (String) everyCell.get(63);
			
			if(!storehours7.equals("")){
				if(storeType.equals("2")){
					setBabyHours(storehours7);
				}else if(storeType.equals("3")){
					setBeautyHours(storehours7);
				}
			}
		}
		if(j ==64){//Store Remark
			String storeRemark = (String) everyCell.get(64);
			
			if(!storeRemark.equals("")){
				
				if(storeType.equals("2")){
					if(!getBabyHours().contains("^B"))
						babyHours ="^B";
					setBabyHours(storeRemark);
				}else if(storeType.equals("3")){
					if(!storeRemark.equals("")){
						if(!getBeautyHours().contains("^T"))
							beautyHours ="^T";
						setBeautyHours(storeRemark);
					}
				}
				
			}
		}
		if(j ==65){//Store Hotline
			String storeHotline = (String) everyCell.get(65);
			
			if(!storeHotline.equals("")){
				
				if(storeType.equals("2")){
					if(!getBabyHours().contains("^B"))
						babyHours ="^B";
					setBabyHours(storeHotline);
				}else if(storeType.equals("3")){
					if(!getBeautyHours().contains("^T"))
						beautyHours ="^T";
					setBeautyHours(storeHotline);
				}
				
			}
		}
		
		if(j ==66){//StoreCloseDate
			storeCloseDate = (String) everyCell.get(66);
		}
		if(j ==67){//Store_code
			position_pos_code = (String) everyCell.get(67);
		}
		if(j ==68){//cc_order_ceiling
			cc_order_ceiling = (String) everyCell.get(68);
		}
		if(j ==69){//cc_order_allowed
			cc_order_allowed = (String) everyCell.get(69);
		}
		
		
		if(j ==23){//GENSTOREHOURS1
			setOpenCloseTime(everyCell);
		}
						
		if( j == 20){ //POSITION_STORE_FEATURE_CODE & POSITION_STORE_FEATURE_NAME
			pharmacy_code = (String) everyCell.get(20);
			if(pharmacy_code.equals("1")){
				pharmacy_code ="P";
				pharmacy_name="Pharmacy";
			}
		}
		
		if(j ==21){//POSITION_STORE_FEATURE_CODE & POSITION_STORE_FEATURE_NAME
			nutrition_code = (String) everyCell.get(21);
			if(nutrition_code.equals("1")){
				nutrition_code ="N";
				nutrition_name="Nutrition";
			}
		}

		if(j ==22){//POSITION_STORE_FEATURE_CODE & POSITION_STORE_FEATURE_NAME
			medicine_code = (String) everyCell.get(22);
			if(medicine_code.equals("1")){
				medicine_code ="C";
				medicine_name="Chinese Medicine";
			}
		}
		
		//Store Type(1 – WATSONS, 2 – BABY, 3 – BEAUTIQ)
		if( j == 55){ 
			String store_code = (String) everyCell.get(55);
//				if(!store_code.equals("2")  && store_code.equals("1")){
			if(store_code.equals("2")){
				baby_code ="B";
				baby_name="Baby";
			}else if(storeType.equals("3")){
				beauty_code ="T";
				beauty_name="Beautiq";
			}

		}
		
		setNullValue();
	}
	/*genergate en end*/
	
	/*genergate zt&zh start */
	public void genergateChin(List everyCell,int j,String lang) throws UnsupportedEncodingException{
		if(j == 0){//编码POSITION_POS_CODE 和 语言编码POSITION_LANG_CODE
			position_pos_code = (String) everyCell.get(0);
			position_pos_code = "3".concat(position_pos_code.trim());
			position_lang_code =lang;
		}
		
		if(j ==9){//名称POSITION_POS_NAME
			if(lang.equals("zt")){
				position_pos_name = (String) everyCell.get(9);
			}else if(lang.equals("zh")){
				position_pos_name = (String) everyCell.get(53);
			}
			
			if(everyCell.get(9).toString().trim().equals(everyCell.get(53).toString().trim())){//Judge zh and zt store name whether equal
				position_pos_name = lang + position_pos_name;
			}
		}
		
		if(j ==12){//街道名POSITION_STREET_NAME
			String strDes = (String) everyCell.get(12);
			strDes = strDes.replace("?", "");
			String[] test =  strDes.split(",");
			for(int k =0;k<test.length;k++){
				if(test.length > 2&& k < test.length -2){
					position_street_name = position_street_name + test[k]+",";
				}else if(test.length  <= 2){
					position_street_name = position_street_name +test[0]+",";
				}
			}
			position_street_name = position_street_name.substring(0,position_street_name.length()-1);
		}
		
		if(j == 3){//镇POSITION_TOWN
			position_town = position_town +(String) everyCell.get(3);
		}
		if(j ==6){//镇POSITION_TOWN
			position_town = (String) everyCell.get(6) +", "+position_town;
		}
		
		if(j ==7){//地区POSITION_DISTRICT
			if(lang.equals("zt")){
				position_district = (String) everyCell.get(7);
			}else if(lang.equals("zh")){
				position_district = (String) everyCell.get(52);
			}
		}
		
		if(j ==1){//国家POSITION_COUNTRY
			position_country = (String) everyCell.get(1);
		}
		
		if(j ==3){//范围POSITION_REGION
			position_region = (String) everyCell.get(3);
		}
		
		if(j ==13){//地址2 POSITION_ADDRESS_LINE_2
			if(lang.equals("zt")){
				position_address_line_2 =  (String)everyCell.get(13);
			}else if(lang.equals("zh")){
				position_address_line_2 = (String) everyCell.get(54);
			}
			//deal with special vulgar characters 60403 start 
			char[] test=new char[position_address_line_2.toCharArray().length];
			for(int k =0;k<position_address_line_2.toCharArray().length;k++){
				if((int)position_address_line_2.toCharArray()[k] == 60403){
					test[k] ='?';
				}else{
					test[k] = position_address_line_2.toCharArray()[k];
				}
			}
			//deal with special vulgar characters 60403 end
			position_address_line_2 = String.valueOf(test); ;
			position_address_line_2 = position_address_line_2.replace("?", "");
		}
		
		if(j==18){//纬度POSITION_LATITUDE
			position_latitude = (String) everyCell.get(18);
		}
		
		if(j ==19){//经度POSITION_LONGITUDE
			position_logitude = (String) everyCell.get(19);
		}
		
		
		if(j ==23){//GENSTOREHOURS1
			String genstorehoursl = (String) everyCell.get(23);
			if(!genstorehoursl.equals("")){
				setGenstorehoursChin(genstorehoursl,lang);
			}
		}
		if(j ==24){//GENSTOREHOURS2
			String genstorehours2 = (String) everyCell.get(24);
			if(!genstorehours2.equals("")){
				setGenstorehoursChin(genstorehours2,lang);
			}
			
		}
		if(j ==25){//GENSTOREHOURS3
			String genstorehours3 = (String) everyCell.get(25);
			if(!genstorehours3.equals("")){
				setGenstorehoursChin(genstorehours3,lang);
			}
		}
		if(j ==26){//GENSTOREHOURS4
			String genstorehours4 = (String) everyCell.get(26);
			if(!genstorehours4.equals("")){
				setGenstorehoursChin(genstorehours4,lang);
			}
		}
		if(j ==27){//GENSTOREHOURS5
			String genstorehours5 = (String) everyCell.get(27);
			if(!genstorehours5.equals("")){
				setGenstorehoursChin(genstorehours5,lang);
			}
		}
		if(j ==28){//GENSTOREHOURS6
			String genstorehours6 = (String) everyCell.get(28);
			if(!genstorehours6.equals("")){
				setGenstorehoursChin(genstorehours6,lang);
			}
		}
		if(j ==29){//GENSTOREHOURS7
			String genstorehours7 = (String) everyCell.get(29);
			if(!genstorehours7.equals("")){
				setGenstorehoursChin(genstorehours7,lang);
			}
		}
		
		if(j ==31){//PHARMACYHOURS1
			String pharmacyhours1 = (String) everyCell.get(31);
			if(!pharmacyhours1.equals("")){
				pharmacyhours ="^P";
				setPharmacyhoursChin(pharmacyhours1,lang);
			}
		}
		if(j ==32){//PHARMACYHOURS2
			String pharmacyhours2 = (String) everyCell.get(32);
			if(!pharmacyhours2.equals("")){
				setPharmacyhoursChin(pharmacyhours2,lang);
			}
		}
		if(j ==33){//PHARMACYHOURS3
			String pharmacyhours3 = (String) everyCell.get(33);
			if(!pharmacyhours3.equals("")){
				setPharmacyhoursChin(pharmacyhours3,lang);
			}
		}
		if(j ==34){//PHARMACYHOURS4
			String pharmacyhours4 = (String) everyCell.get(34);
			if(!pharmacyhours4.equals("")){
				setPharmacyhoursChin(pharmacyhours4,lang);
			}
		}
		if(j ==35){//PHARMACYHOURS5
			String pharmacyhours5 = (String) everyCell.get(35);
			if(!pharmacyhours5.equals("")){
				setPharmacyhoursChin(pharmacyhours5,lang);
			}
		}
		if(j ==36){//PHARMACYHOURS6
			String pharmacyhours6 = (String) everyCell.get(36);
			if(!pharmacyhours6.equals("")){
				setPharmacyhoursChin(pharmacyhours6,lang);
			}
		}
		if(j ==37){//PHARMACYHOURS7
			String pharmacyhours7 = (String) everyCell.get(37);
			if(!pharmacyhours7.equals("")){
				setPharmacyhoursChin(pharmacyhours7,lang);
			}
		}
		
		
		
		
		
		//TODO how to add P remark and hotline
		if(j ==38){//PHARMACY Remark
			String pharmacyRemark = (String) everyCell.get(38);
			if(!pharmacyRemark.equals("")){
				if(!getPharmacyhours().contains("^P"))
					pharmacyhours ="^P";
				setPharmacyhoursChin(pharmacyRemark,lang);
			}
		}
		if(j ==39){//PHARMACY Hotline
			String pharmacyHotline = (String) everyCell.get(39);
			if(!pharmacyHotline.equals("")){
				if(!getPharmacyhours().contains("^P"))
					pharmacyhours ="^P";
				setPharmacyhoursChin(pharmacyHotline,lang);
			}
		}
		//TODO how to add N remark and hotline
		
		if(j ==40){//NUTRITION Remark
			String nutritionRemark = (String) everyCell.get(40);
			if(!nutritionRemark.equals("")){
				if(!getNutritionhours().contains("^N"))
					nutritionhours ="^N";
				setNutritionhoursChin(nutritionRemark,lang);
			}
		}
		if(j ==41){//NUTRITION Hotline
			String nutritionHotline = (String) everyCell.get(41);
			if(!nutritionHotline.equals("")){
				if(!getNutritionhours().contains("^N"))
					nutritionhours ="^N";
				setNutritionhoursChin(nutritionHotline,lang);
			}
		}
		
		
		if(j ==42){//CHIMEDHOURS1
			String chimedhours1 = (String) everyCell.get(42);
			if(!chimedhours1.equals("")){
				chimedhours ="^C";
				setChimedhoursChin(chimedhours1,lang);
			}
		}
		if(j ==43){//CHIMEDHOURS2
			String chimedhours2 = (String) everyCell.get(43);
			if(!chimedhours2.equals("")){
				setChimedhoursChin(chimedhours2,lang);
			}
		}
		if(j ==44){//CHIMEDHOURS3
			String chimedhours3 = (String) everyCell.get(44);
			if(!chimedhours3.equals("")){
				setChimedhoursChin(chimedhours3,lang);
			}
		}
		if(j ==45){//CHIMEDHOURS4
			String chimedhours4 = (String) everyCell.get(45);
			if(!chimedhours4.equals("")){
				setChimedhoursChin(chimedhours4,lang);
			}
		}
		if(j ==46){//CHIMEDHOURS5
			String chimedhours5 = (String) everyCell.get(46);
			if(!chimedhours5.equals("")){
				setChimedhoursChin(chimedhours5,lang);
			}
		}
		if(j ==47){//CHIMEDHOURS6
			String chimedhours6 = (String) everyCell.get(47);
			if(!chimedhours6.equals("")){
				setChimedhoursChin(chimedhours6,lang);
			}
		}
		if(j ==48){//CHIMEDHOURS7
			String chimedhours7 = (String) everyCell.get(48);
			if(!chimedhours7.equals("")){
				setChimedhoursChin(chimedhours7,lang);
			}
		}
		if(j ==49){//CHIMED Remark
			String chimedRemark = (String) everyCell.get(49);
			if(!chimedRemark.equals("")){
				if(!getChimedhours().contains("^C"))
					chimedhours ="^C";
				setChimedhoursChin(chimedRemark,lang);
			}
		}
		if(j ==50){//CHIMED Hotline
			String chimedHotline = (String) everyCell.get(50);
			if(!chimedHotline.equals("")){
				if(!getChimedhours().contains("^C"))
					chimedhours ="^C";
				setChimedhoursChin(chimedHotline,lang);
			}
		}
		

		String storeType = (String) everyCell.get(55);
		storeType=storeType.trim();
		
		if(j ==57){//STOREHOURS1
			String storehours1 = (String) everyCell.get(57);
			
			if(!storehours1.equals("")){
				if(storeType.equals("2")){
					babyHours ="^B";
					setBabyHoursChin(storehours1,lang);
				}else if(storeType.equals("3")){
					beautyHours ="^T";
					setBeautyHoursChin(storehours1,lang);
				}
			}
		}
		if(j ==58){//STOREHOURS2
			String storehours2 = (String) everyCell.get(58);
			
			if(!storehours2.equals("")){
				if(storeType.equals("2")){
					setBabyHoursChin(storehours2,lang);
				}else if(storeType.equals("3")){
					setBeautyHoursChin(storehours2,lang);
				}
			}
		}
		if(j ==59){//STOREHOURS3
			String storehours3 = (String) everyCell.get(59);
			
			if(!storehours3.equals("")){
				if(storeType.equals("2")){
					setBabyHoursChin(storehours3,lang);
				}else if(storeType.equals("3")){
					setBeautyHoursChin(storehours3,lang);
				}
			}
		}
		if(j ==60){//STOREHOURS4
			String storehours4 = (String) everyCell.get(60);
			
			if(!storehours4.equals("")){
				if(storeType.equals("2")){
					setBabyHoursChin(storehours4,lang);
				}else if(storeType.equals("3")){
					setBeautyHoursChin(storehours4,lang);
				}
			}
		}
		if(j ==61){//STOREHOURS5
			String storehours5 = (String) everyCell.get(61);
			
			if(!storehours5.equals("")){
				if(storeType.equals("2")){
					setBabyHoursChin(storehours5,lang);
				}else if(storeType.equals("3")){
					setBeautyHoursChin(storehours5,lang);
				}
			}
		}
		if(j ==62){//STOREHOURS6
			String storehours6 = (String) everyCell.get(62);
			
			if(!storehours6.equals("")){
				if(storeType.equals("2")){
					setBabyHoursChin(storehours6,lang);
				}else if(storeType.equals("3")){
					setBeautyHoursChin(storehours6,lang);
				}
			}
		}
		if(j ==63){//STOREHOURS7
			String storehours7 = (String) everyCell.get(63);
			
			if(!storehours7.equals("")){
				if(storeType.equals("2")){
					setBabyHoursChin(storehours7,lang);
				}else if(storeType.equals("3")){
					setBeautyHoursChin(storehours7,lang);
				}
			}
		}
		
		if(j ==64){//Store Remark
			String storeRemark = (String) everyCell.get(64);
			
			if(!storeRemark.equals("")){
				
				if(storeType.equals("2")){
					if(!getBabyHours().contains("^B"))
						babyHours ="^B";
					setBabyHoursChin(storeRemark,lang);
				}else if(storeType.equals("3")){
					if(!getBeautyHours().contains("^T"))
						beautyHours ="^T";
					setBeautyHoursChin(storeRemark,lang);
				}
			}
		}
		if(j ==65){//Store Hotline
			String storeHotline = (String) everyCell.get(65);
			
			if(!storeHotline.equals("")){
				
				if(storeType.equals("2")){
					if(!getBabyHours().contains("^B"))
						babyHours ="^B";
					setBabyHoursChin(storeHotline,lang);
				}else if(storeType.equals("3")){
					if(!getBeautyHours().contains("^T"))
						beautyHours ="^T";
					setBeautyHoursChin(storeHotline,lang);
				}
			}
		}
		
		if(j ==66){//StoreCloseDate
			storeCloseDate = (String) everyCell.get(66);
		}
		if(j ==67){//Store_code
			position_pos_code = (String) everyCell.get(67);
		}
		if(j ==68){//cc_order_ceiling
			cc_order_ceiling = (String) everyCell.get(68);
		}
		if(j ==69){//cc_order_allowed
			cc_order_allowed = (String) everyCell.get(69);
		}
		
		
		
		if(j ==23){//GENSTOREHOURS1
			setOpenCloseTime(everyCell);
		}
						
		if( j == 20){ //POSITION_STORE_FEATURE_CODE & POSITION_STORE_FEATURE_NAME
			pharmacy_code = (String) everyCell.get(20);
			if(pharmacy_code.equals("1")){
				pharmacy_code ="P";
				pharmacy_name="Pharmacy";
			}
		}
		
		if(j ==21){//POSITION_STORE_FEATURE_CODE & POSITION_STORE_FEATURE_NAME
			nutrition_code = (String) everyCell.get(21);
			if(nutrition_code.equals("1")){
				nutrition_code ="N";
				nutrition_name="Nutrition";
			}
		}

		if(j ==22){//POSITION_STORE_FEATURE_CODE & POSITION_STORE_FEATURE_NAME
			medicine_code = (String) everyCell.get(22);
			if(medicine_code.equals("1")){
				medicine_code ="C";
				medicine_name="Chinese Medicine";
			}
		}
		
		
		//Store Type(1 – WATSONS, 2 – BABY, 3 – BEAUTIQ)
		if( j == 55){ 
			String store_code = (String) everyCell.get(55);
			
//			if(!store_code.equals("2")  && store_code.equals("1")){
			if(store_code.equals("2")){
				baby_code ="B";
				baby_name="Baby";
			}else if(storeType.equals("3")){
				beauty_code ="T";
				beauty_name="Beautiq";
			}
		}
		
	   setNullValue();
	}
	/*genergate zt&zh end */
		
	public static void main(String[] arg) throws Exception{
		AutoGenergatedMain agm = new AutoGenergatedMain();
		String inputFile = arg[0];
		String outputFile = arg[1];
		if(!inputFile.trim().equals("") && inputFile !=null){
			List<List> translate  = agm.readSheet2Excel(inputFile);
			agm.toList(translate);
			List<List> result  = agm.readSheet1Excel(inputFile);
			List eachRow = agm.parseExcel(result);
			if(!outputFile.trim().equals("") && outputFile !=null){
				String fi = outputFile;
				File file = new File(fi);
				agm.cvsServiceImpl.writeListToCVSFile(eachRow, file.getAbsolutePath());
			}
		}
	}
}
