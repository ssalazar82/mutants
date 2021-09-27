package com.meli.challenge.mutant.unitest.domaintest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.meli.challenge.mutant.domain.exception.BadDnaSequenceException;
import com.meli.challenge.mutant.domain.service.MutantService;
import com.meli.challenge.mutant.domain.service.contract.IMatrixService;
import com.meli.challenge.mutant.domain.service.contract.IMutantService;
import com.meli.challenge.mutant.infrastructure.dto.StatDto;
import com.meli.challenge.mutant.infrastructure.service.DnaService;
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
	
	/*
	 * Valida calculo de ratio en las estadisticas
	 * */
	@Test
	public void DtoStatsTest() {
		StatDto stats = new StatDto();
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		stats.setCountHumanDna(dnaService.countHumans());
		stats.setCountMutantDna(dnaService.countMutants());
		stats.setRatio(0);
		
		assertThat(stats.getRatio()).isEqualTo(0.4);

	}

	/*
	 * Valida get de las estadisticas - Human
	 * */
	@Test
	public void DtoStatsGetHumanTest() {
		StatDto stats = new StatDto();
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		stats.setCountHumanDna(dnaService.countHumans());
		stats.setCountMutantDna(dnaService.countMutants());
		stats.setRatio(0);
		
		assertThat(stats.getCountHumanDna()).isEqualTo(100);

	}
	
	/*
	 * Valida get de las estadisticas - Mutant
	 * */
	@Test
	public void DtoStatsGetMutantTest() {
		StatDto stats = new StatDto();
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		stats.setCountHumanDna(dnaService.countHumans());
		stats.setCountMutantDna(dnaService.countMutants());
		stats.setRatio(0);
		
		assertThat(stats.getCountMutantDna()).isEqualTo(40);

	}
}
