/**
 * ErrorCode.java
 *
 * @description: Codigos de error de la capa de dominio.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.util;

public enum ErrorCode {

	MIN_SIZE_MATRIX_ERROR ("ERR_DNA_01"),
	MAX_SIZE_MATRIX_ERROR ("ERR_DNA_02"),
	MATRIX_ERROR ("ERR_DNA_03"),
	DNA_SEQUENCE_ERROR ("ERR_DNA_04"),
	ACCESS_DENIED ("ERR_DNA_05"),
	INTERNAL_SERVER_ERROR ("ERR_DNA_06");

	private final String value;

	ErrorCode(String value) {
		this.value = value;
	}

	/**
	 * @return the code
	 */
	public String getValue() {
		return value;
	}

}
