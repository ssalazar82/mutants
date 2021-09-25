package com.meli.challenge.mutant.unitest.builder;

public class MutantDnaBuilder {

	private String[] dna;
	
	public  MutantDnaBuilder() {
		this.dna = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
