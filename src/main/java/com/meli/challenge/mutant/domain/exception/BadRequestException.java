/**
 * BadRequestException.java
 *
 * @description: Excepcion que representa un error de cliente.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.domain.exception;

import com.meli.challenge.mutant.util.ErrorCode;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

	private final String code;

	public BadRequestException(ErrorCode code,String message) {
		super(message);
		this.code=code.getValue();
	}

	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
