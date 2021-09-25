/**
 * RouteRepository.java
 *
 * @description: Implementación del repositorio de rutas.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.infrastructure.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.meli.challenge.mutant.infrastructure.model.Dna;
import com.meli.challenge.mutant.infrastructure.repository.contract.IDnaRepository;


@Repository
public class DnaRepository implements IDnaRepository  {

	 private final MongoOperations mongoOperations;

	    @Autowired
	    public DnaRepository(MongoOperations mongoOperations) {
	        this.mongoOperations = mongoOperations;
	    }
	    
	    public Optional<List<Dna>> findAll() {
	    	List<Dna> dnas = this.mongoOperations.find(new Query(), Dna.class);
	        Optional<List<Dna>> optionalDnas = Optional.ofNullable(dnas);
	        return optionalDnas;
		}   
	    
	    public int countMutants() {
	    	List<Dna> dnas = this.mongoOperations.find(new Query(Criteria.where("isMutant").is(true)), Dna.class);
	        return dnas.size();
		}   

	    public int countHumans() {
	    	List<Dna> dnas = this.mongoOperations.find(new Query(Criteria.where("isMutant").is(false)), Dna.class);
	        return dnas.size();
		}   

	    
	    public Optional<Dna> findOne(String dnaId) {
	        Dna d = this.mongoOperations.findOne(new Query(Criteria.where("dna").is(dnaId)), Dna.class);
	        Optional<Dna> dna = Optional.ofNullable(d);
	        return dna;
	    }

	    public Dna saveDna(Dna dna) {
	    	
	    	dna.setId(
	    			Arrays.asList(dna.getDna())
	    	        .stream()
	    	        .collect(Collectors.joining(""))
	    			);  
	        
	        this.mongoOperations.save(dna);
	        return dna;
	    }
	    
	    public void updateDna(Dna dna) {
	        this.mongoOperations.save(dna);
	    }

	    public void deleteDna(String dnaId) {
	        this.mongoOperations.findAndRemove(new Query(Criteria.where("dna").is(dnaId)), Dna.class);
	    }
}
