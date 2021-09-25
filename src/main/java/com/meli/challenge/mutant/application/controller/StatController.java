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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.meli.challenge.mutant.domain.service.contract.IStatService;
import com.meli.challenge.mutant.infrastructure.dto.StatDto;
import com.meli.challenge.mutant.infrastructure.service.contract.IDnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/stats")
@Api(value = "Controlador para estadisticas de las verificaciones de ADN")
public class StatController {

	
	
    private final IStatService statService;
    
	@Autowired
	public StatController(IStatService statService, IDnaService dnaService )
	{	
		this.statService = statService;
	}
	
	/**
	 * devuelva un Json con las estadísticas de las
     * verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
	 */
	@ApiOperation(value = "Estadisticas mutanes y humanos.", notes = "")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StatDto> getStats()  {	
		 
			return new ResponseEntity<>(this.statService.getStats(),OK);

	}	
}

