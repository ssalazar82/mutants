package com.meli.challenge.mutant.domain.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.challenge.mutant.domain.exception.BadDnaSequenceException;
import com.meli.challenge.mutant.domain.property.MutantProperties;
import com.meli.challenge.mutant.domain.service.contract.IMatrixService;
import com.meli.challenge.mutant.domain.service.contract.IMutantService;
import com.meli.challenge.mutant.domain.strategy.HorizontalAnalyze;
import com.meli.challenge.mutant.domain.strategy.ObliqueBottomUpAnalyze;
import com.meli.challenge.mutant.domain.strategy.ObliqueTopDownAnalyze;
import com.meli.challenge.mutant.domain.strategy.VerticalAnalyze;
import com.meli.challenge.mutant.domain.strategy.contract.IAnalyzeStrategy;
import com.meli.challenge.mutant.infrastructure.model.Dna;
import com.meli.challenge.mutant.infrastructure.service.contract.IDnaService;
import com.meli.challenge.mutant.util.ErrorCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("mutantService")
public class MutantService implements IMutantService {
	
	private static final Logger logger = LogManager.getLogger(MutantService.class);

	private IMatrixService matrixService;
	private IDnaService dnaService;
	private IAnalyzeStrategy analyzeStrategy;
	
	@Autowired
	public MutantService(IMatrixService matrixService,IDnaService dnaService ) {
		this.matrixService = matrixService;
		this.dnaService = dnaService;
	}
	
	public boolean isMutant(String[] dna) {
		
		boolean isMutant = false;
		
		//Se valida que las secuencias de AND contengan los caracteres (A,T,C,G)
		validateDnaBaseSequence(dna);
		
		//matrix NxN
		this.matrixService.isMatrixNxN(dna);
		
		//Convierto String[] a Matrix[n][n]
		char[][] matrix = this.matrixService.convertArrayStringToMatrix(dna);
		isMutant=validateStrategies(matrix);
		
		/*Registro en Bd*/
		 registerBd(dna, isMutant);

		 logger.info("isMutant: " + isMutant);
		 
		 return isMutant;
	}
	
	private void registerBd(String[] dna,boolean isMutant) {
		Dna data = new Dna();
		data.setMutant(isMutant);
		data.setDna(dna);
		this.dnaService.saveDna(data);
	}
	
	/*
	 * Validar la secuencia de ADN de acuerdo a los metodos especificados
	 * */
	private boolean validateStrategies(char[][] matrix) {
		int countFoundSequences = 0;
		this.analyzeStrategy = new VerticalAnalyze();
		countFoundSequences+= analyzeStrategy.analizeSequence(matrix);
		
		this.analyzeStrategy = new HorizontalAnalyze();
		countFoundSequences+=analyzeStrategy.analizeSequence(matrix);
		
		this.analyzeStrategy = new ObliqueBottomUpAnalyze();
		countFoundSequences+=analyzeStrategy.analizeSequence(matrix);
		
		this.analyzeStrategy = new ObliqueTopDownAnalyze();
		countFoundSequences+=analyzeStrategy.analizeSequence(matrix);
		
		if(countFoundSequences >= MutantProperties.QUANTITY_MINIMAL_SEQUENCE) {
			logger.info("--------Strategies found repeat:"+countFoundSequences+"-------------");
			return true;
		}
		
		logger.info("--------Strategies found repeat:"+countFoundSequences+"-------------");
		
		return false;
	}
	
	public boolean validateDnaBaseSequence(String[] dna) {
	
		Pattern pattern = Pattern.compile("[A]|[T]|[C]|[G]");
	    boolean matchFound = true;
	    
	    for(String baseSequence  : dna) {
	    	for (char baseLetter : baseSequence.toCharArray()) {
		        Matcher matcher = pattern.matcher(Character.toString(baseLetter));
		        if(!matcher.matches()) {
		        	matchFound = false;
		        	throw new BadDnaSequenceException(ErrorCode.DNA_SEQUENCE_ERROR,"The sequence does not correspond to the dna structure (A,T,C,G)");
		        }
	    	}
	    }
	    return matchFound;
	}
    
}
