package com.meli.challenge.mutant.infrastructure.exception;

import org.springframework.core.NestedRuntimeException;

public class DnaNotFoundException extends NestedRuntimeException{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DnaNotFoundException(String dnaId) {
	        super(String.format("Dna with  Id '%s' not founded", dnaId));
	    }
}
