package com.meli.challenge.mutant.unitest.builder;

public class MaxSizeMatrixIncorrectBuilder {

	private String[] dna;
	
	public  MaxSizeMatrixIncorrectBuilder() {
		this.dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG","AAAAAA","AAAAAA","AAAAAA","AAAAAA","AAAAAA"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
