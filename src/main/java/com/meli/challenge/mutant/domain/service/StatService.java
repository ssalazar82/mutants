package com.meli.challenge.mutant.domain.service;

import com.meli.challenge.mutant.domain.service.contract.IStatService;
import com.meli.challenge.mutant.infrastructure.dto.StatDto;
import com.meli.challenge.mutant.infrastructure.service.contract.IDnaService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("statService")
public class StatService implements IStatService {
	private static final Logger logger = LogManager.getLogger(StatService.class);

	private IDnaService dnaService;
	
	@Autowired
	public StatService(IDnaService dnaService ) {
		this.dnaService = dnaService;
	}
	
	@Override
	public StatDto getStats() {
		
		StatDto stats = new StatDto();
		stats.setCountMutantDna(this.dnaService.countMutants());
		stats.setCountHumanDna(this.dnaService.countHumans());
		logger.info("stats:"+stats.getCountMutantDna()+"-"+stats.getCountHumanDna()+"-"+stats.getRatio());
		return stats;
		
	}

}
