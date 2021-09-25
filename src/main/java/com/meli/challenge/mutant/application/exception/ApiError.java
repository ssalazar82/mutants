/**
 * ApiError.java
 *
 * @description: Encapsula información de error que se retornara a los clientes de las apis.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.application.exception;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError  {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String status;
	private String message;
	private String path;
	
	public ApiError(String message, String path)
	{
		this.status="";
		this.timestamp=LocalDateTime.now();
		this.message=message;
		this.path=path;
	}

	public ApiError(String status, String message, String path)
	{
		this.timestamp=LocalDateTime.now();
		this.status=status;
		this.message=message;
		this.path=path;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param code the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}




}
