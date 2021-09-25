package com.meli.challenge.mutant.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Model class of controller
 * @author Sergio Salazar
 *
 */
@Document(collection = "dnas")
@JsonPropertyOrder({"dna"})
public class Dna implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @NotNull  
    private String id;
    
    @NotNull  
    private String[] dna;
    @NotNull    
    private boolean isMutant;
	public String[] getDna() {
		return dna;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setDna(String[] dna) {
		this.dna = dna;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
	
}
