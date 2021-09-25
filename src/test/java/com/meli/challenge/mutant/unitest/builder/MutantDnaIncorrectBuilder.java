package com.meli.challenge.mutant.unitest.builder;

public class MutantDnaIncorrectBuilder {

	private String[] dna;
	
	public  MutantDnaIncorrectBuilder() {
		this.dna = new String[]{"ATGCGF","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
