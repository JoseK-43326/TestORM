package com.JoseK.TestDAO;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	public static java.sql.Date strToDate(String regx) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(regx);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return new java.sql.Date(date.getTime());
	}
}
