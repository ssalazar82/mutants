package com.meli.challenge.mutant.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateUTC {

	static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

	/***
	 * Constructor privado
	 */
	private DateUTC() {
		//Constructor privado
	}
	
	/***
	 * Obtener fecha UTC
	 * @return fecha
	 */
	public static Date getDate() {		
		return stringToDate(getString());
	}

	/***
	 * Obtener fecha UTC
	 * @return fecha
	 */
	public static String getString() {
		final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(new Date());
	}

	/***
	 * Convertir una fecha de tipo string a tipo date 
	 * @param strDate fecha en tipo string
	 * @return fecha en tipo date
	 */
	private static Date stringToDate(String strDate) {
		Date dateToReturn = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);

		try {
			dateToReturn = dateFormat.parse(strDate);
		} catch (ParseException e) {
			dateToReturn = new Date();
		} 
		
		return dateToReturn;
	}

}

