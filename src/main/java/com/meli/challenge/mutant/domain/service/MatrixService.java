package com.meli.challenge.mutant.domain.service;

import org.springframework.stereotype.Service;

import com.meli.challenge.mutant.domain.exception.BadMinSizeMatrixException;
import com.meli.challenge.mutant.domain.exception.BadSizeMatrixException;
import com.meli.challenge.mutant.domain.exception.ExceedMaxSizeMatrixException;
import com.meli.challenge.mutant.domain.service.contract.IMatrixService;
import com.meli.challenge.mutant.util.ErrorCode;


@Service("matrixService")
public class MatrixService implements IMatrixService {
	
	private static final int MAX_SIZE_MATRIX = 10;
	private static final int MIN_SIZE_MATRIX = 5;
	
	public MatrixService() {
		
	}
	
	public char[][] convertArrayStringToMatrix(String[] dna){
		/*Valida el tamaño maxino de una matrix*/
		validateMaxSizeMatrix(dna);
		
		/*Antes de convertir en matrix se valida que sea una matrix NxN*/
		isMatrixNxN(dna);
		
		char matrix[][] = new char[dna.length][dna.length];
		   
		for (int row = 0; row < dna.length; row++) {
			   char[] charInRow = dna[row].toCharArray();
			   for (int col = 0; col < charInRow.length; col++) {
				   matrix[row][col] = charInRow[col];
		       }
		}
		
		return matrix;
	}
	
	public boolean validateMaxSizeMatrix(String[] dna) {
		System.out.println("length:"+dna.length + " max:"+MAX_SIZE_MATRIX);
		if(dna.length>MAX_SIZE_MATRIX)
			throw new ExceedMaxSizeMatrixException(ErrorCode.MAX_SIZE_MATRIX_ERROR, "The matrix exceed the max size available "+ MAX_SIZE_MATRIX);
		return true;
	}
	
	public boolean validateMinSizeMatrix(String[] dna) {
		if(dna.length<MIN_SIZE_MATRIX)
			throw new BadMinSizeMatrixException(ErrorCode.MIN_SIZE_MATRIX_ERROR, "The matrix is too much small.  Should be minimun "+MIN_SIZE_MATRIX);
		return true;
	}
	
	
	public boolean isMatrixNxN(String[] dna) {
		for (String sequence : dna) {
			if(sequence.length() != dna.length) {
				throw new BadSizeMatrixException(ErrorCode.MATRIX_ERROR, "Invalid size the rows or columns not correspond to a matrix (NxN)");
			}
		}
		return true;
	}
    
}
