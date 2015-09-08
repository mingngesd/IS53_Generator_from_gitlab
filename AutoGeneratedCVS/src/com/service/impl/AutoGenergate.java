package com.service.impl;

import java.util.ArrayList;
import java.util.List;

public class AutoGenergate {
	List eachlist = new ArrayList();
	static List enWord = new ArrayList(); 
	static List ztWord = new ArrayList(); 
	static List zhWord = new ArrayList(); 
	String position_pos_code ="";//编码POSITION_POS_CODE 
	String position_lang_code ="";//语言编码POSITION_LANG_CODE
	String position_pos_name="";//名称POSITION_POS_NAME
	String position_description =""; //描述POSITION_DESCRIPTION
	String position_street_name ="";//街道名POSITION_STREET_NAME
	int position_street_number = 0;//街道号码POSITION_STREET_NUMBER
	String position_town ="";//镇POSITION_TOWN
	String position_county ="";   //州POSITION_COUNTY
	String position_province =""; //省POSITION_PROVINCE
	String position_district="";//地区POSITION_DISTRICT
	String position_metro_area="";//首都POSITION_METRO_AREA
	String position_cross_street="";//POSITION_CROSS_STREET 
	String position_country ="";//国家POSITION_COUNTRY
	String position_region = "";//范围POSITION_REGION
	String position_address_line_2 ="";//地址2 POSITION_ADDRESS_LINE_2
	String position_address_line_3 ="";//地址3 POSITION_ADDRESS_LINE_3
	String position_address_line_4 ="";//地址4 POSITION_ADDRESS_LINE_4
	String position_address_line_5 ="";//地址5 POSITION_ADDRESS_LINE_5
	String position_address_line_6 ="";//地址6 POSITION_ADDRESS_LINE_6
	String position_address_line_7 ="";//地址7 POSITION_ADDRESS_LINE_7
	String position_zip_code ="";//编码(这一列有一个空格)POSITION_ZIP_CODE
	String position_zip_ext="";//POSITION_ZIP_CODE_EXT
	String position_latitude="";//纬度POSITION_LATITUDE
	String position_logitude = "";//经度POSITION_LONGITUDE
	String position_content="";//内容POSITION_CONTENT
	String storeCloseDate="";//StoreCloseDate
	String phoneNumber="";//PhoneNumber
	String position_opening_schedule="";//POSITION_OPENING_SCHEDULE
	String genstorehours="";  //GENSTOREHOURS
	String pharmacyhours="";  //PHARMACYHOURS1
	String chimedhours="";  //CHIMEDHOURS2
	String nutritionhours="";//NUTRITIONHOURS
	String babyHours = "";//BABYHOURS
	String beautyHours = "";//BEAUTYHOURS
	String position_sunday_opentime ="";//星期日开门时间POSITION_SUNDAY_OPENTIME
	String position_sunday_closetime ="";//星期日关门时间POSITION_SUNDAY_CLOSETIME
	String position_monday_opentime ="";//星期一开门时间POSITION_MONDAY_OPENTIME
	String position_monday_closetime ="";//星期一关门时间POSITION_MONDAY_CLOSETIME
	String position_tuesday_opentime ="";//星期二开门时间POSITION_TUESDAY_OPENTIME
	String position_tuesday_closetime ="";//星期二关门时间POSITION_TUESDAY_CLOSETIME
	String position_wednesday_opentime ="";//星期三开门时间POSITION_WEDNESDAY_OPENTIME
	String position_wednesday_closetime ="";//星期三关门时间POSITION_WEDNEDAY_CLOSETIME
	String position_thursday_opentime ="";//星期四开门时间POSITION_THURSDAY_OPENTIME
	String position_thursday_closetime ="";//星期四关门时间POSITION_THURSDAY_CLOSETIME
	String position_friday_opentime ="";//星期五开门时间POSITION_FRIDAY_OPENTIME
	String position_friday_closetime ="";//星期五关门时间POSITION_FRIDAY_CLOSETIME
	String position_saturday_opentime ="";//星期六开门时间POSITION_SATURDAY_OPENTIME
	String position_saturday_closetime ="";//星期六关门时间POSITION_SATURDAY_CLOSETIME
	String pharmacy_code ="";//POSITION_STORE_FEATURE_CODE 
	String pharmacy_name ="";//POSITION_STORE_FEATURE_NAME
	String nutrition_code ="";//POSITION_STORE_FEATURE_CODE 
	String nutrition_name ="";//POSITION_STORE_FEATURE_NAME
	String medicine_code ="";//POSITION_STORE_FEATURE_CODE 
	String medicine_name ="";//POSITION_STORE_FEATURE_NAME
	String baby_code = "";//POSITION_STORE_FEATURE_NAME
	String baby_name = "";//POSITION_STORE_FEATURE_CODE
	String beauty_code = "";//POSITION_STORE_FEATURE_NAME
	String beauty_name = "";//POSITION_STORE_FEATURE_CODE
	String cc_order_ceiling = "";//Maximum Click and Collect order can be supported
	String cc_order_allowed = "";//Is Click and Collect order allowed
	
	public void reSetParam(){
		 position_pos_code ="";//编码POSITION_POS_CODE 
		 position_lang_code ="";//语言编码POSITION_LANG_CODE
		 position_pos_name="";//名称POSITION_POS_NAME
		 position_description =""; //描述POSITION_DESCRIPTION
		 position_street_name ="";//街道名POSITION_STREET_NAME
		 position_street_number = 0;//街道号码POSITION_STREET_NUMBER
		 position_town ="";//镇POSITION_TOWN
		 position_county ="";   //州POSITION_COUNTY
		 position_province =""; //省POSITION_PROVINCE
		 position_district="";//地区POSITION_DISTRICT
		 position_metro_area="";//首都POSITION_METRO_AREA
		 position_cross_street="";//POSITION_CROSS_STREET 
		 position_country ="";//国家POSITION_COUNTRY
		 position_region = "";//范围POSITION_REGION
		 position_address_line_2 ="";//地址2 POSITION_ADDRESS_LINE_2
		 position_address_line_3 ="";//地址3 POSITION_ADDRESS_LINE_3
		 position_address_line_4 ="";//地址4 POSITION_ADDRESS_LINE_4
		 position_address_line_5 ="";//地址5 POSITION_ADDRESS_LINE_5
		 position_address_line_6 ="";//地址6 POSITION_ADDRESS_LINE_6
		 position_address_line_7 ="";//地址7 POSITION_ADDRESS_LINE_7
		 position_zip_code ="";//编码(这一列有一个空格)POSITION_ZIP_CODE
		 position_zip_ext="";//POSITION_ZIP_CODE_EXT
		 position_latitude="";//纬度POSITION_LATITUDE
		 position_logitude = "";//经度POSITION_LONGITUDE
		 position_content="";//内容POSITION_CONTENT
		 storeCloseDate="";//StoreCloseDate
		 phoneNumber="";//PhoneNumber
		 position_opening_schedule="";//POSITION_OPENING_SCHEDULE
		 genstorehours="";  //GENSTOREHOURS
		 pharmacyhours="";  //PHARMACYHOURS1
		 nutritionhours=""; //NUTRITIONHOURS
		 chimedhours="";  //CHIMEDHOURS2
		 babyHours = "";  //BABYHOURS
		 beautyHours = ""; //BEAUTYHOURS
		 position_sunday_opentime ="";//星期日开门时间POSITION_SUNDAY_OPENTIME
		 position_sunday_closetime ="";//星期日关门时间POSITION_SUNDAY_CLOSETIME
		 position_monday_opentime ="";//星期一开门时间POSITION_MONDAY_OPENTIME
		 position_monday_closetime ="";//星期一关门时间POSITION_MONDAY_CLOSETIME
		 position_tuesday_opentime ="";//星期二开门时间POSITION_TUESDAY_OPENTIME
		 position_tuesday_closetime ="";//星期二关门时间POSITION_TUESDAY_CLOSETIME
		 position_wednesday_opentime ="";//星期三开门时间POSITION_WEDNESDAY_OPENTIME
		 position_wednesday_closetime ="";//星期三关门时间POSITION_WEDNEDAY_CLOSETIME
		 position_thursday_opentime ="";//星期四开门时间POSITION_THURSDAY_OPENTIME
		 position_thursday_closetime ="";//星期四关门时间POSITION_THURSDAY_CLOSETIME
		 position_friday_opentime ="";//星期五开门时间POSITION_FRIDAY_OPENTIME
		 position_friday_closetime ="";//星期五关门时间POSITION_FRIDAY_CLOSETIME
		 position_saturday_opentime ="";//星期六开门时间POSITION_SATURDAY_OPENTIME
		 position_saturday_closetime ="";//星期六关门时间POSITION_SATURDAY_CLOSETIME
		 pharmacy_code ="";//POSITION_STORE_FEATURE_CODE 
		 pharmacy_name ="";//POSITION_STORE_FEATURE_NAME
		 nutrition_code ="";//POSITION_STORE_FEATURE_CODE 
		 nutrition_name ="";//POSITION_STORE_FEATURE_NAME
		 medicine_code ="";//POSITION_STORE_FEATURE_CODE 
		 medicine_name ="";//POSITION_STORE_FEATURE_NAME
		 baby_code = "";//POSITION_STORE_FEATURE_NAME
		 baby_name = "";//POSITION_STORE_FEATURE_CODE
		 beauty_code = "";//POSITION_STORE_FEATURE_NAME
		 beauty_name = "";//POSITION_STORE_FEATURE_CODE
		 cc_order_ceiling = "";//Maximum Click and Collect order can be supported
		 cc_order_allowed = "";//Is Click and Collect order allowed
	}
	
	public String getEachRow(){
		String eachRow ="";
		position_opening_schedule = genstorehours.trim() + pharmacyhours.trim() +chimedhours.trim() +nutritionhours.trim() + babyHours.trim() + beautyHours.trim();// P/N/C/B/T
		eachRow = position_pos_code+"|"+position_lang_code+"|"+position_pos_name+"|"+position_description+"|"+position_street_name+"|"+position_street_number+"|"+position_town+"|"
				  +position_county+"|"+position_province+"|"+position_district+"|"+position_metro_area+"|"+position_cross_street+"|"
				  +position_country+"|"+position_region+"|"+position_address_line_2+"|"+position_address_line_3+"|"+position_address_line_4+"|"
				  +position_address_line_5+"|"+position_address_line_6+"|"+position_address_line_7+"|"+position_zip_code+"|"+position_zip_ext+"|"
				  +position_latitude+"|"+position_logitude+"|"+position_content+"|"+position_opening_schedule+"|"
				  +position_sunday_opentime+"|"+position_sunday_closetime+"|"+position_monday_opentime+"|"+position_monday_closetime+"|"+position_tuesday_opentime+"|"+position_tuesday_closetime
				  +"|"+position_wednesday_opentime+"|"+position_wednesday_closetime+"|"+position_thursday_opentime+"|"+position_thursday_closetime+"|"+position_friday_opentime
				  +"|"+position_friday_closetime+"|"+position_saturday_opentime+"|"+position_saturday_closetime+"|"+storeCloseDate+"|"+phoneNumber+"|"+cc_order_ceiling+"|"+cc_order_allowed+"|";
		if(!pharmacy_name.equals("")){
			eachRow = eachRow +pharmacy_code+"|"+pharmacy_name+"|";
		}
		if(!nutrition_name.equals("")){
			eachRow = eachRow +nutrition_code+"|"+nutrition_name+"|";
		}
		if(!medicine_name.equals("")){
			eachRow = eachRow +medicine_code+"|"+medicine_name+"|";
		}
		if(!baby_name.equals("")){
			eachRow = eachRow +baby_code+"|"+baby_name+"|";
		}
		if(!beauty_name.equals("")){
			eachRow = eachRow +beauty_code+"|"+beauty_name+"|";
		}
		eachRow = eachRow +"\r\n";
		return eachRow;
	}
	
	public void setNullValue(){
		 position_description ="";//描述POSITION_DESCRIPTION
		 position_street_number = 0;//街道号码POSITION_STREET_NUMBER
		 position_county ="";   //州POSITION_COUNTY
		 position_province =""; //省POSITION_PROVINCE
		 position_metro_area="";//首都POSITION_METRO_AREA
		 position_cross_street="";//POSITION_CROSS_STREET 
		 position_address_line_3 ="";//地址3 POSITION_ADDRESS_LINE_3
		 position_address_line_4 ="";//地址4 POSITION_ADDRESS_LINE_4
		 position_address_line_5 ="";//地址5 POSITION_ADDRESS_LINE_5
		 position_address_line_6 ="";//地址6 POSITION_ADDRESS_LINE_6
		 position_address_line_7 ="";//地址7 POSITION_ADDRESS_LINE_7
		 position_zip_code =" ";//编码(这一列有一个空格)POSITION_ZIP_CODE
		 position_zip_ext="";//POSITION_ZIP_CODE_EXT
		 position_content="";//内容POSITION_CONTENT
	}
	
	public void setOpenCloseTime(List everyCell){
		String opentime = "1000",closetime = "2200";
		 position_sunday_opentime =opentime;//星期日开门时间POSITION_SUNDAY_OPENTIME
		 position_sunday_closetime =closetime;//星期日关门时间POSITION_SUNDAY_CLOSETIME
		 position_monday_opentime =opentime;//星期一开门时间POSITION_MONDAY_OPENTIME
		 position_monday_closetime =closetime;//星期一关门时间POSITION_MONDAY_CLOSETIME
		 position_tuesday_opentime =opentime;//星期二开门时间POSITION_TUESDAY_OPENTIME
		 position_tuesday_closetime =closetime;//星期二关门时间POSITION_TUESDAY_CLOSETIME
		 position_wednesday_opentime =opentime;//星期三开门时间POSITION_WEDNESDAY_OPENTIME
		 position_wednesday_closetime =closetime;//星期三关门时间POSITION_WEDNEDAY_CLOSETIME
		 position_thursday_opentime =opentime;//星期四开门时间POSITION_THURSDAY_OPENTIME
		 position_thursday_closetime =closetime;//星期四关门时间POSITION_THURSDAY_CLOSETIME
		 position_friday_opentime =opentime;//星期五开门时间POSITION_FRIDAY_OPENTIME
		 position_friday_closetime =closetime;//星期五关门时间POSITION_FRIDAY_CLOSETIME
		 position_saturday_opentime =opentime;//星期六开门时间POSITION_SATURDAY_OPENTIME
		 position_saturday_closetime =closetime;//星期六关门时间POSITION_SATURDAY_CLOSETIME
	}
	
	public String translateLang(String name,String lang){
		String str = name;
		String name1="",name2="";
		if(name.indexOf("(")> -1){
			 name1 = name.split("\\(")[0].replace("-", "-");
			 name2 = name.split("\\(")[1];
		}
		for(int i = 0;i < enWord.size();i++){
			if(name1.indexOf("-")>-1){
				if(name2.split("\\)")[0].indexOf((String)enWord.get(i))>-1){
					if(lang.equals("zt")){name2 = name2.replace((String)enWord.get(i),(String)ztWord.get(i));}
					if(lang.equals("zh")){name2 = name2.replace((String)enWord.get(i),(String)zhWord.get(i));}
				}
			}else if(str.indexOf("-") == -1){
				boolean flag = false;
				for(int j = 0; j < enWord.size(); j++){
					if(str.contains("Nutrition") && ((String)enWord.get(j)).contains("Nutrition")){
						if(lang.equals("zt")){str = str.replace((String)enWord.get(j),(String)ztWord.get(j));}
						if(lang.equals("zh")){str = str.replace((String)enWord.get(j),(String)zhWord.get(j));}
						flag = true;
					}
				}
				
				if(!flag && str.indexOf((String)enWord.get(i))>-1){
					if(lang.equals("zt")){str = str.replace((String)enWord.get(i),(String)ztWord.get(i));}
					if(lang.equals("zh")){str = str.replace((String)enWord.get(i),(String)zhWord.get(i));}
				}
			}
		}
		if(name1.indexOf("-")>-1){
			str = name1 +"(" + name2;
		}
		
		return str;
	}
	
	public void setGenstorehours(String genstorehours1){
		genstorehours = genstorehours.trim();
		if(genstorehours.equals("")){
			genstorehours ="^"+genstorehours1;
		}else{
			genstorehours =genstorehours+"^"+genstorehours1;
		}
	}
	
	public void setPharmacyhours(String pharmacyhours1){
		pharmacyhours = pharmacyhours.trim();
		pharmacyhours =pharmacyhours+"^"+pharmacyhours1;
	}
	
	public String getPharmacyhours() {
		return pharmacyhours;
	}
	
	
	public void setNutritionhours(String nutritionhours1) {
		nutritionhours = nutritionhours.trim();
		nutritionhours =nutritionhours+"^"+nutritionhours1;
	}
	
	public String getNutritionhours() {
		return nutritionhours;
	}

	public void setChimedhours(String chimedhours1){
		chimedhours = chimedhours.trim();
		chimedhours =chimedhours+"^"+chimedhours1;
	}
	
	public String getChimedhours() {
		return chimedhours;
	}

	public void setBabyHours(String babyHours1){
		babyHours = babyHours.trim();
		babyHours =babyHours+"^"+babyHours1;
	}
	public String getBabyHours() {
		return babyHours;
	}

	public void setBeautyHours(String beautyHours1){
		beautyHours = beautyHours.trim();
		beautyHours = beautyHours+"^"+beautyHours1;
	}
	
	public String getBeautyHours() {
		return beautyHours;
	}

	public void setGenstorehoursChin(String genstorehoursl,String lang){
		genstorehours = genstorehours.trim();
		if(genstorehours.trim().equals("")){
			genstorehours = "^"+lang+"^"+translateLang(genstorehoursl,lang);
		}else{
			genstorehours = genstorehours + "^"+translateLang(genstorehoursl,lang);
		}
	
	}
	
	public void setPharmacyhoursChin(String pharmacyhours1,String lang){
		pharmacyhours = pharmacyhours.trim();
		pharmacyhours = pharmacyhours+"^"+translateLang(pharmacyhours1,lang);
	}
	
	public void setNutritionhoursChin(String nutritionhours1,String lang) {
		nutritionhours = nutritionhours.trim();
		nutritionhours =nutritionhours+"^"+translateLang(nutritionhours1,lang);
	}
	
	public void setChimedhoursChin(String chimedhours1,String lang){
		chimedhours = chimedhours.trim();
		chimedhours = chimedhours+"^"+translateLang(chimedhours1,lang);
	}
	
	public void setBabyHoursChin(String Babyhours1,String lang){
		babyHours = babyHours.trim();
		babyHours =babyHours+"^"+ translateLang(Babyhours1,lang);
	}
	
	public void setBeautyHoursChin(String Beautyhours1,String lang){
		beautyHours = beautyHours.trim();
		beautyHours = beautyHours+"^"+translateLang(Beautyhours1,lang);
	}

	
	
	
}
