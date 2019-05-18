package com.wjj.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
		//测试1.获取某月最后一天日期
		//String date = getLastDate("yyyy-MM-dd");
		
		//测试2.获取某月第一天日期
		//String date = getFirstDate("yyyy-MM-dd");
		
		
		
		//System.out.println(date);
	}
	
	//获取某月最后一天日期
	public static String getLastDate(String patten) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
	
	//获取某月第一天日期
	public static String getFirstDate(String string) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
	
	//将字符串转换成日期	YYYY-MM-dd 2010-10-10
	public Date toDate(String patten,String date) {
		try {
			return new SimpleDateFormat(patten).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//将日期转换成字符串
	public String toString(String patten,String date) {
		return new SimpleDateFormat(patten).format(date);
	}
	
}
