package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date dateForm = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dateForm = simpleDateFormat.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return dateForm;
	}


}
