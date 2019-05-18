package com.wjj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.MONTH, 5);
//		System.out.println(calendar.get(Calendar.MONTH));
//		calendar.add(Calendar.MONTH, 1);
//		System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		/*calendar.set(Calendar.DAY_OF_MONTH, 0);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));*/
		
		/*String string = getLastDateOfMonth("yyyy-MM-dd");
		System.out.println(string);*/
		getFirstDateMonth("yyyy-MM-dd");
		
	}
	
	//获取某月最后一天日期
    public static String getLastDateOfMonth(String pattern){
       Calendar calendar= Calendar.getInstance();
       calendar.add(Calendar.MONTH, 1);
       calendar.set(Calendar.DAY_OF_MONTH, 0);
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return sdf.format(calendar.getTime());
    }
   
   //获取某月第一天日期
    public static void getFirstDateMonth(String stringType) throws ParseException{
       Calendar calendar=Calendar.getInstance();
       calendar.add(Calendar.MONTH,1);
       System.out.println(calendar.get(Calendar.MONTH));
       calendar.set(Calendar.DAY_OF_MONTH, 1);
       System.out.println(calendar.get(Calendar.MONTH));
       System.out.println(calendar.getTime());
    }
    
    //将字符串转换成日期	YYYY-MM-dd 2010-10-10
    public Date toDate(String pattern,String date){
    	try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    //将日期转换成字符串
    public String toString(String pattern,Date date){
    	return new SimpleDateFormat(pattern).format(date);
    }
	
}
