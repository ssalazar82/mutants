package com.meli.challenge.mutant.domain.service.contract;

public interface IMatrixService {
	public boolean isMatrixNxN(String[] dna);
	public char[][] convertArrayStringToMatrix(String[] dna);
	public boolean validateMaxSizeMatrix(String[] dna);
	public boolean validateMinSizeMatrix(String[] dna);
}
