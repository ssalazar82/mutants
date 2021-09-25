package com.meli.challenge.mutant.unitest.builder;

public class MaxSizeMatrixCorrectBuilder {

	private String[] dna;
	
	public  MaxSizeMatrixCorrectBuilder() {
		this.dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
