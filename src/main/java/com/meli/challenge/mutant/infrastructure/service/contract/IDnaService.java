package com.meli.challenge.mutant.infrastructure.service.contract;

import java.util.List;

import com.meli.challenge.mutant.infrastructure.model.Dna;



public interface IDnaService {

        List<Dna> findAll();
		
	    Dna findByDnaId(String dnaId);

	    Dna saveDna(Dna dna);

	    void updateDna(Dna dna);

	    int countMutants();
	    
	    int countHumans();

}
