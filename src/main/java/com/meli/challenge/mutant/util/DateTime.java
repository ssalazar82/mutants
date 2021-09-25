/**
 * DateTime.java
 *
 * @description: Clase base para operaciones con fecha.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	private DateTime()
	{}

	/**
	 * Convierte una fecha en un objeto LocalDate del framework.
	 * @param date Fecha en texto
	 * @return LocalDate
	 */
	public static LocalDate convertToDate(String date)
	{
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(DateFormatType.DATE.getPattern()));
	}
	
	public static LocalDate convertoToLocalDate(LocalDateTime dateTime)
	{
		return LocalDate.of(dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth());
		
	}

	/**
	 * Convierte una fecha en un objeto LocalDateTime del framework.
	 * @param date Fecha en texto
	 * @return LocalDateTime
	 */
	public static LocalDateTime convertToDateTime(String date)
	{
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateFormatType.DATETIME.getPattern()));
	}
	
	/**
	 * Retorna una fecha en un formato especifico.
	 * @param dateTime
	 * @param format
	 * @return
	 */
	public static String format(LocalDateTime dateTime,DateFormatType format) {
		
		 return dateTime.format(DateTimeFormatter.ofPattern(format.getPattern()));
	}


	/**
	 * Obtiene la fecha actual en el formato especificado.
	 * @param formatType
	 * @return Fecha actual.
	 */
	public static final String now(DateFormatType formatType)
	{
		String date;
		switch(formatType)
		{
		case DATE: 
			date =  LocalDate.now().format(DateTimeFormatter.ofPattern(formatType.getPattern()));
			break;
		case DATETIME:
			date = LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatType.getPattern()));
			break;
		default:
			date =  LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatType.getPattern()));
		}
		return date;

	}
}
