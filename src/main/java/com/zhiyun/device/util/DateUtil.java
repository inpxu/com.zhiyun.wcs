package com.zhiyun.device.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String nowToStr(){
		return format.format(new Date());
	}
	
	public static Date strToDate(String dateStr){
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(strToDate("20E1-01-00 90:97:32"));
	}

}
