package com.meli.challenge.mutant.unitest.builder;

public class MinSizeMatrixCorrectBuilder {

	private String[] dna;
	
	public  MinSizeMatrixCorrectBuilder() {
		this.dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
