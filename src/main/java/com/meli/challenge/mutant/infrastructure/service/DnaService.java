package com.meli.challenge.mutant.infrastructure.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meli.challenge.mutant.infrastructure.exception.DnaNotFoundException;
import com.meli.challenge.mutant.infrastructure.model.Dna;
import com.meli.challenge.mutant.infrastructure.repository.contract.IDnaRepository;
import com.meli.challenge.mutant.infrastructure.service.contract.IDnaService;

@Service("dnaService")
@Transactional
public class DnaService implements IDnaService {

private static final Log log = LogFactory.getLog(DnaService.class);
	
	private IDnaRepository dnaRepository;

    @Autowired
    public DnaService(IDnaRepository dnaRepository){
        this.dnaRepository = dnaRepository;
    }


    public Dna findByDnaId(String dnaId) {
        Optional<Dna> dna = dnaRepository.findOne(dnaId);
        if (dna.isPresent()) {
            log.debug(String.format("Read dnaId '{}'", dnaId));
            return dna.get();
        }else
            throw new DnaNotFoundException(dnaId);
    }
    

    public int countMutants() {
    	return dnaRepository.countMutants();
    }

    public int countHumans() {
    	return dnaRepository.countHumans();
    }
   
    public List<Dna> findAll() {
        Optional<List<Dna>> dna = dnaRepository.findAll();
        return dna.get();      
    }
    
   
    public Dna saveDna(Dna dna) {
        return dnaRepository.saveDna(dna);
    }

 
    public void updateDna(Dna dna) {
        dnaRepository.updateDna(dna);
    }

}
