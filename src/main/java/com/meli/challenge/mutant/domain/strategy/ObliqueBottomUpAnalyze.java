package com.meli.challenge.mutant.domain.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.meli.challenge.mutant.domain.property.MutantProperties;
import com.meli.challenge.mutant.domain.strategy.contract.IAnalyzeStrategy;
import com.meli.challenge.mutant.util.StringUtils;

public class ObliqueBottomUpAnalyze implements IAnalyzeStrategy {
	private static final Logger logger = LogManager.getLogger(ObliqueBottomUpAnalyze.class);
	
	@Override
	public int analizeSequence(char[][] matrix) {
		int repeatedBase = 0;
			
		for (int i = (MutantProperties.QUANTITY_CHARACTERS - 1);i < matrix.length ; i++) { 
			String dnaBase = "";
		    for (int j = 0; j <= i; j ++) {
		    	dnaBase += matrix[i-j][j];
		    }
		    repeatedBase += StringUtils.getCharsConsecutiveInString(dnaBase);
		}

		for (int i=0;i < (matrix.length - MutantProperties.QUANTITY_CHARACTERS); i++) { 
			String dnaBase = "";
		    for (int j=0 ; j<matrix.length-i-1; j++) { 
		    	dnaBase +=matrix[matrix.length-j-1][j+i+1];
		    }
		    repeatedBase += StringUtils.getCharsConsecutiveInString(dnaBase);		
		}
		
		logger.info("ObliqueBlAnalyze found " + repeatedBase  );
		
		return repeatedBase;
	}

}
