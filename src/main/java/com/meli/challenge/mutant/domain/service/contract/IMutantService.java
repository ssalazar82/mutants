package com.meli.challenge.mutant.domain.service.contract;

public interface IMutantService {
	public boolean isMutant(String[] dna);
	public boolean validateDnaBaseSequence(String[] dna);
}
