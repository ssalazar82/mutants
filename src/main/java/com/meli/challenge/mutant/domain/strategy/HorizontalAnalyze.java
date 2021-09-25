package com.meli.challenge.mutant.domain.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.meli.challenge.mutant.domain.strategy.contract.IAnalyzeStrategy;
import com.meli.challenge.mutant.util.StringUtils;

public class HorizontalAnalyze implements IAnalyzeStrategy {
	private static final Logger logger = LogManager.getLogger(HorizontalAnalyze.class);
	
	@Override
	public int analizeSequence(char[][] matrix) {
		int repeatedBase = 0;
		
		//se recorre matrix horizontalmente
		for (int row = 0; row < matrix.length; row++) {
			String dnaBase = "";
			for (int col = 0; col < matrix.length; col++) {
				dnaBase += matrix[row][col];
			}
			repeatedBase += StringUtils.getCharsConsecutiveInString(dnaBase);
		}
		
		logger.info("HorizontalAnalyze found "+repeatedBase);
		
		return repeatedBase;
	}

}
