/**
 * DateFormatTypes.java
 *
 * @description: Tipos de formatos de fecha utilizados por la aplicación.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.util;


public enum DateFormatType {
	
	DATE ("yyyy-MM-dd"),
	DATETIME ("yyyy-MM-dd'T'HH:mm:ss");

	private final String pattern;
	
	DateFormatType(String pattern) {
	      this.pattern=pattern;
	  }

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}
}
