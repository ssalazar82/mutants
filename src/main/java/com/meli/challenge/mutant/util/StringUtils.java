package com.meli.challenge.mutant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.meli.challenge.mutant.domain.property.MutantProperties;



public class StringUtils {
	
	private static final Logger logger = LogManager.getLogger(StringUtils.class);
	
	/*
	 * Valida el numero de caracteres repetido de forma secuencial,
	 * Se utiliza expresion regular para hacerlo, teniendo como restriccion la cantidad de caracteres QUANTITY_CHARACTERS
	 * */
	public static int getCharsConsecutiveInString(String sequence) {
		
		
		int countRepeated = 0;
		
		Pattern pattern = Pattern.compile("([A-Z])\\1{3}");

        Matcher matcher = pattern.matcher(sequence);
        if(matcher.find()) {
        	
        	countRepeated++;
        	logger.info("Sequence-:"+sequence+" "+countRepeated + " Properties:"+MutantProperties.QUANTITY_CHARACTERS);
        	
        }
        
        logger.info("Sequence-:"+sequence );
        
		return countRepeated;
	    
	}
}
