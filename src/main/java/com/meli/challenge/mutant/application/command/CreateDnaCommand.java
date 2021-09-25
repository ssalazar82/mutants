package com.meli.challenge.mutant.application.command;

import javax.validation.constraints.NotNull;

public class CreateDnaCommand {
	    
	@NotNull(message="La cadena de adn no puede ser nula")
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

}
