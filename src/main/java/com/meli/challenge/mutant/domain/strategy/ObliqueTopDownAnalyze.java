package com.meli.challenge.mutant.domain.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.meli.challenge.mutant.domain.property.MutantProperties;
import com.meli.challenge.mutant.domain.strategy.contract.IAnalyzeStrategy;
import com.meli.challenge.mutant.util.StringUtils;

public class ObliqueTopDownAnalyze implements IAnalyzeStrategy {
	private static final Logger logger = LogManager.getLogger(ObliqueTopDownAnalyze.class);
	
	@Override
	public int analizeSequence(char[][] matrix) {
		int repeatedBase = 0;

		
		for (int row = (matrix.length - MutantProperties.QUANTITY_CHARACTERS); row >= 0 ; row--) { 
			String dnaBase = "";
		    for (int col = 0; col < (matrix.length - row); col ++) {
		    	dnaBase += matrix[row + col][col];
		    }
		    
		    repeatedBase += StringUtils.getCharsConsecutiveInString(dnaBase);
		    		
		}

		for (int col = 0; col < (matrix.length - MutantProperties.QUANTITY_CHARACTERS); col++) { 
			String dnaBase = "" ;
		    for (int row=0 ; row < matrix.length -col -1; row++) { 
		    	dnaBase +=matrix[row][row+col+1];
		    }
		    
		    repeatedBase += StringUtils.getCharsConsecutiveInString(dnaBase);
	
		}
		
		logger.info("ObliqueTopDownAnalyze found "+repeatedBase);
		
		return repeatedBase;
	}

}
