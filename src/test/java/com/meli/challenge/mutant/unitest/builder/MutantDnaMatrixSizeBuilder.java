package com.meli.challenge.mutant.unitest.builder;

public class MutantDnaMatrixSizeBuilder {

	private String[] dna;
	
	public  MutantDnaMatrixSizeBuilder() {
		this.dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTGTA"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
