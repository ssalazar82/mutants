package com.meli.challenge.mutant.domain.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.meli.challenge.mutant.domain.strategy.contract.IAnalyzeStrategy;
import com.meli.challenge.mutant.util.StringUtils;

public class VerticalAnalyze implements IAnalyzeStrategy {
	private static final Logger logger = LogManager.getLogger(VerticalAnalyze.class);

	@Override
	public int analizeSequence(char[][] matrix) {
		
		int repeatedBase = 0;
		
		//Se recorre matrix hacia abajo
		for (int col = 0; col < matrix.length; col++) {
			
			String dnaBase = "";
			
			for (int row = 0; row < matrix.length; row++) {
				dnaBase += matrix[row][col];
			}
			
			repeatedBase += StringUtils.getCharsConsecutiveInString(dnaBase);
			
		}
		
		logger.info("VerticalAnalyze found "+repeatedBase);
		
		return repeatedBase;
	}
}
	