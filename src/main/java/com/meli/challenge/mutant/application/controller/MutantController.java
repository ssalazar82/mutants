/**
 * MutantController.java
 *
 * @description: Controlador que administra las consultas de Magneto.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/
package com.meli.challenge.mutant.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.meli.challenge.mutant.application.command.CreateDnaCommand;
import com.meli.challenge.mutant.domain.service.contract.IMutantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.FORBIDDEN;


import javax.validation.Valid;

@RestController
@RequestMapping("/mutant")
@Api(value = "Controlador para reclutar mutantes")
public class MutantController {

	
	
    private final IMutantService mutantService;
	
	@Autowired
	public MutantController(IMutantService mutantService)
	{	
		this.mutantService = mutantService;
	}
	
	/**
	 * Indica si un humano es mutante o no de acuerdo a su secuencia de ADN.
	 * @return 200 OK si es mutante, en caso contrario un 403 Forbidden.
	 */
	@ApiOperation(value = "Indica si un humano es mutante o no de acuerdo a su secuencia de ADN.", notes = "")
	@PostMapping("/")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Void> isMutant(@Valid @RequestBody CreateDnaCommand createDnaCommand)  {	
		if(this.mutantService.isMutant(createDnaCommand.getDna())) 
			return new ResponseEntity<>(OK);

		return new ResponseEntity<>(FORBIDDEN);
	}	
}

