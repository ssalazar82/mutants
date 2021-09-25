package com.meli.challenge.mutant.unitest.domaintest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.meli.challenge.mutant.domain.exception.BadDnaSequenceException;
import com.meli.challenge.mutant.domain.service.MutantService;
import com.meli.challenge.mutant.domain.service.contract.IMatrixService;
import com.meli.challenge.mutant.domain.service.contract.IMutantService;
import com.meli.challenge.mutant.infrastructure.service.contract.IDnaService;
import com.meli.challenge.mutant.unitest.builder.MutantDnaBuilder;
import com.meli.challenge.mutant.unitest.builder.MutantDnaIncorrectBuilder;

public class MutantDomainTest {

	private String[] dna;
	private String[] dnaIncorrect;
	
	private IMutantService mutantService;

	@Before 
	public void initialize() {
		this.dna = new MutantDnaBuilder().Build();
		this.dnaIncorrect = new MutantDnaIncorrectBuilder().Build();
		mutantService = new MutantService(mock(IMatrixService.class), mock(IDnaService.class));
	}

	/*
	 * Las letras de los Strings solo pueden ser: (A,T,C,G), las
	 * cuales representa cada base nitrogenada del ADN	
	 * */
	@Test
	public void baseDnaTest() {
	    boolean matchFound = this.mutantService.validateDnaBaseSequence(dna);    	
	    assertTrue(matchFound);
	}
	
	/*
	 * Las letras de los Strings solo pueden ser: (A,T,C,G), las
	 * cuales representa cada base nitrogenada del ADN	
	 * */
	@Test
	public void baseDnaIncorrectTest() {
		Throwable thrown = catchThrowable(() -> {
			this.mutantService.validateDnaBaseSequence(dnaIncorrect);
		});
			
		assertThat(thrown).isInstanceOf(BadDnaSequenceException.class);

	}
}
