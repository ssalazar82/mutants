package com.meli.challenge.mutant.unitest.applicationtest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

import com.meli.challenge.mutant.unitest.builder.MutantDnaBuilder;


public class DnaSecuenceTableTest {

	private String[] dna;

	@Before 
	public void initialize() {
		this.dna = new MutantDnaBuilder().Build();
	}

	/*
	 * Valida NxN
	 * */
	@Test
	public void SizeTableTest() {
		int rows = this.dna.length;
		int cols = this.dna.length;
		assertThat(rows).isEqualTo(cols);
	}

}
