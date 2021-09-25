package com.meli.challenge.mutant.infrastructure.repository.contract;

import java.util.List;
import java.util.Optional;

import com.meli.challenge.mutant.infrastructure.model.Dna;


public interface IDnaRepository {

	Optional<List<Dna>> findAll();

    public Optional<Dna> findOne(String dna);

    public Dna saveDna(Dna dna);

    public void updateDna(Dna dna);
    
    public int countMutants();
    
    public int countHumans();

}
