package com.meli.challenge.mutant.unitest.domaintest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import com.meli.challenge.mutant.domain.exception.BadMinSizeMatrixException;
import com.meli.challenge.mutant.domain.exception.BadSizeMatrixException;
import com.meli.challenge.mutant.domain.exception.ExceedMaxSizeMatrixException;
import com.meli.challenge.mutant.domain.service.MatrixService;
import com.meli.challenge.mutant.domain.service.contract.IMatrixService;
import com.meli.challenge.mutant.unitest.builder.MaxSizeMatrixCorrectBuilder;
import com.meli.challenge.mutant.unitest.builder.MaxSizeMatrixIncorrectBuilder;
import com.meli.challenge.mutant.unitest.builder.MinSizeMatrixCorrectBuilder;
import com.meli.challenge.mutant.unitest.builder.MinSizeMatrixIncorrectBuilder;
import com.meli.challenge.mutant.unitest.builder.MutantDnaBuilder;
import com.meli.challenge.mutant.unitest.builder.MutantDnaMatrixSizeBuilder;

public class MatrixtDomainTest {

	private String[] dna;
	private String[] dnaMatrixIncorrect;
	private String[] maxSizeMatrixIncorrect;
	private String[] maxSizeMatrixCorrect;
	private String[] minSizeMatrixIncorrect;
	private String[] minSizeMatrixCorrect;
	
	private IMatrixService matrixService;

	@Before 
	public void initialize() {
		this.dna = new MutantDnaBuilder().Build();
		this.maxSizeMatrixIncorrect = new MaxSizeMatrixIncorrectBuilder().Build();
		this.maxSizeMatrixCorrect = new MaxSizeMatrixCorrectBuilder().Build();
		this.minSizeMatrixIncorrect = new MinSizeMatrixIncorrectBuilder().Build();
		this.minSizeMatrixCorrect = new MinSizeMatrixCorrectBuilder().Build();
		this.dnaMatrixIncorrect = new MutantDnaMatrixSizeBuilder().Build();
		matrixService = new MatrixService();
	}

	
	
	/*Matrix NxN*/
	@Test
	public void SizeMatrixCorrectTest() {

		boolean matchFound = this.matrixService.isMatrixNxN(dna);   
		assertThat(matchFound).isEqualTo(true);
	}
	
	/*Matrix NxN incorrect*/
	@Test
	public void SizeMatrixIncorrectTest() {

		Throwable thrown = catchThrowable(() -> {
			this.matrixService.isMatrixNxN(dnaMatrixIncorrect);
		});
			
		assertThat(thrown).isInstanceOf(BadSizeMatrixException.class);
	}
	
	/*Matrix Max Dimension*/
	@Test
	public void MaxSizeMatrixCorrectTest() {
		assertTrue(this.matrixService.validateMaxSizeMatrix(maxSizeMatrixCorrect));
	}
	
	/*Matrix Max Dimension*/
	@Test
	public void MaxSizeMatrixIncorrectTest() {

		Throwable thrown = catchThrowable(() -> {
			this.matrixService.validateMaxSizeMatrix(maxSizeMatrixIncorrect);
		});
			
		assertThat(thrown).isInstanceOf(ExceedMaxSizeMatrixException.class);
	}
	
	/*Matrix Min Dimension*/
	@Test
	public void MinSizeMatrixCorrectTest() {
		assertTrue(this.matrixService.validateMaxSizeMatrix(minSizeMatrixCorrect));
	}
	
	/*Matrix Min Dimension*/
	@Test
	public void MinSizeMatrixIncorrectTest() {

		Throwable thrown = catchThrowable(() -> {
			this.matrixService.validateMinSizeMatrix(minSizeMatrixIncorrect);
		});
			
		assertThat(thrown).isInstanceOf(BadMinSizeMatrixException.class);
	}
	

	



}
