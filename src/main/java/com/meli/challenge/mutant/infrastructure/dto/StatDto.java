package com.meli.challenge.mutant.infrastructure.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StatDto {

	
	private int countMutantDna;
	private int countHumanDna;
    private double ratio;
    
    @JsonProperty("count_mutant_dna")
	public long getCountMutantDna() {
		return countMutantDna;
	}
	
    @JsonProperty("count_human_dna")
	public long getCountHumanDna() {
		return countHumanDna;
	}
	
	public double getRatio() {
	    return countHumanDna !=0 ?(double)countMutantDna/(double)countHumanDna : 0;
	}
	
	public void setCountMutantDna(int countMutantDna) {
		this.countMutantDna = countMutantDna;
	}
	
	public void setCountHumanDna(int countHumanDna) {
		this.countHumanDna = countHumanDna;
	}
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
}
