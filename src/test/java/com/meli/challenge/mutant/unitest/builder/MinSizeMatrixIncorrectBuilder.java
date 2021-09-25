package com.meli.challenge.mutant.unitest.builder;

public class MinSizeMatrixIncorrectBuilder {

	private String[] dna;
	
	public  MinSizeMatrixIncorrectBuilder() {
		this.dna = new String[]{"ATGCGA","CAGTGC"};
	}
	
	public String[] Build() {
		return this.dna;
	}
	
}
