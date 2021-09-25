/**
 * GlobalControllerExceptionHandler.java
 *
 * @description: Manejador de las excepciones que propagan los endpoint de la web api.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.application.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.meli.challenge.mutant.domain.exception.BadDnaSequenceException;
import com.meli.challenge.mutant.domain.exception.BadMinSizeMatrixException;
import com.meli.challenge.mutant.domain.exception.BadRequestException;
import com.meli.challenge.mutant.domain.exception.ExceedMaxSizeMatrixException;
import com.meli.challenge.mutant.util.ErrorCode;

import org.springframework.security.access.AccessDeniedException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final Logger log=LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	
	/**
	 * Maneja las excepciones secuencia dna.
	 * @param ex Excepcion
	 * @param request Peticion enviada por el cliente
	 * @return Objeto de error.
	 */
	@ExceptionHandler(BadDnaSequenceException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public final  ApiError handleBadDnaSequenceException(BadDnaSequenceException ex, WebRequest request)
	{
		log.error(ex.getMessage(), ex);
		return new ApiError(ex.getCode(),ex.getMessage(),request.getDescription(false));
	}


	@ExceptionHandler(ExceedMaxSizeMatrixException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public final  ApiError handleExceedMaxSizeMatrixException(ExceedMaxSizeMatrixException ex, WebRequest request)
	{
		log.error(ex.getMessage(), ex);
		return new ApiError(ex.getCode(),ex.getMessage(),request.getDescription(false));
	}
	
	@ExceptionHandler(BadMinSizeMatrixException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public final  ApiError handleBadMinSizeMatrixException(BadMinSizeMatrixException ex, WebRequest request)
	{
		log.error(ex.getMessage(), ex);
		return new ApiError(ex.getCode(),ex.getMessage(),request.getDescription(false));
	}

	
	/**
	 * Maneja las excepciones de acceso denegado.
	 * @param ex Excepcion
	 * @param request Peticion enviada por el cliente
	 * @return Objeto de error.
	 */
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(code=HttpStatus.FORBIDDEN)
	public final  ApiError handleHttpMessageNotReadableException(AccessDeniedException ex, WebRequest request)
	{
		log.error(ex.getMessage(), ex);		
		return new ApiError(ErrorCode.ACCESS_DENIED.getValue() ,ex.toString(),request.getDescription(false));
	}

	
	/**
	 * Maneja las excepciones del tipo BadRequestException.
	 * @param ex Excepcion
	 * @param request Peticion
	 * @return ApiError
	 */
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public final  ApiError handleBadRequestException(BadRequestException ex, WebRequest request)
	{
		log.error(ex.getMessage(), ex);
		return new ApiError(ex.getCode(),ex.getMessage(),request.getDescription(false));
	}
	
	
	/**
	 * Maneja las excepciones de validación de los mensajes de entrada de los endpoint de los controladores.
	 * @param ex Excepcion
	 * @param request Peticion
	 * @return ApiError
	 */
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public  ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request,HttpServletRequest httpRequest) {

		String errorMessage = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.findFirst()
				.orElse(ex.getMessage());
	
		log.error(errorMessage, ex);
		return new ApiError(ErrorCode.METHOD_ARGUMENT_NOT_VALID.getValue(),errorMessage,request.getDescription(false));
	}
	*/
	
	
	/**
	 * Maneja el resto de excepciones que no son especificadas en esta clase.
	 * @param ex Excepcion
	 * @param request Peticion
	 * @return ApiError
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public  ApiError handleUnknownException(Exception ex, WebRequest request) {
	
		log.error(ex.getMessage(), ex);
		return new ApiError(ErrorCode.INTERNAL_SERVER_ERROR.getValue(),ex.toString(),request.getDescription(false));
	}

}
