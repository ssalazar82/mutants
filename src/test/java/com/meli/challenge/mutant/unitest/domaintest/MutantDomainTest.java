package com.meli.challenge.mutant.unitest.domaintest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;

import com.meli.challenge.mutant.domain.exception.BadDnaSequenceException;
import com.meli.challenge.mutant.domain.service.MatrixService;
import com.meli.challenge.mutant.domain.service.MutantService;
import com.meli.challenge.mutant.domain.service.StatService;
import com.meli.challenge.mutant.domain.service.contract.IMatrixService;
import com.meli.challenge.mutant.domain.service.contract.IMutantService;
import com.meli.challenge.mutant.domain.service.contract.IStatService;
import com.meli.challenge.mutant.infrastructure.dto.StatDto;
import com.meli.challenge.mutant.infrastructure.model.Dna;
import com.meli.challenge.mutant.infrastructure.repository.DnaRepository;
import com.meli.challenge.mutant.infrastructure.service.DnaService;
import com.meli.challenge.mutant.infrastructure.service.contract.IDnaService;
import com.meli.challenge.mutant.unitest.builder.MutantDnaBuilder;
import com.meli.challenge.mutant.unitest.builder.MutantDnaIncorrectBuilder;

public class MutantDomainTest {

	private String[] dna;
	private String[] dnaIncorrect;
	
	private IMutantService mutantService;
	private IStatService statService;

	@Before 
	public void initialize() {
		this.dna = new MutantDnaBuilder().Build();
		this.dnaIncorrect = new MutantDnaIncorrectBuilder().Build();
		mutantService = new MutantService(mock(IMatrixService.class), mock(IDnaService.class));
		
	}

	/*
	 * Las letras de los Strings solo pueden ser: (A,T,C,G), las
	 * cuales representa cada base nitrogenada del ADN	
	 * */
	@Test
	public void baseDnaTest() {
	    boolean matchFound = this.mutantService.validateDnaBaseSequence(dna);    	
	    assertTrue(matchFound);
	}
	
	/*
	 * Las letras de los Strings solo pueden ser: (A,T,C,G), las
	 * cuales representa cada base nitrogenada del ADN	
	 * */
	@Test
	public void baseDnaIncorrectTest() {
		Throwable thrown = catchThrowable(() -> {
			this.mutantService.validateDnaBaseSequence(dnaIncorrect);
		});
			
		assertThat(thrown).isInstanceOf(BadDnaSequenceException.class);

	}
	
	/*
	 * Valida calculo de ratio en las estadisticas
	 * */
	@Test
	public void DtoStatsTest() {
		StatDto stats = new StatDto();
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		stats.setCountHumanDna(dnaService.countHumans());
		stats.setCountMutantDna(dnaService.countMutants());
		stats.setRatio(0);
		
		assertThat(stats.getRatio()).isEqualTo(0.4);

	}

	/*
	 * Valida get de las estadisticas - Human
	 * */
	@Test
	public void DtoStatsGetHumanTest() {
		StatDto stats = new StatDto();
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		stats.setCountHumanDna(dnaService.countHumans());
		stats.setCountMutantDna(dnaService.countMutants());
		stats.setRatio(0);
		
		assertThat(stats.getCountHumanDna()).isEqualTo(100);

	}
	
	/*
	 * Valida service Dna 
	 * */
	@Test
	public void ServiceDnaTest() {
		DnaService dnaService = new DnaService(mock(DnaRepository.class));
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		assertThat(dnaService.countHumans()).isEqualTo(100);

	}
	
	/*
	 * Valida get de las estadisticas - Mutant
	 * */
	@Test
	public void DtoStatsGetMutantTest() {
		StatDto stats = new StatDto();
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		
		stats.setCountHumanDna(dnaService.countHumans());
		stats.setCountMutantDna(dnaService.countMutants());
		stats.setRatio(0);
		
		assertThat(stats.getCountMutantDna()).isEqualTo(40);

	}
	
	/*
	 * Uso del servicio de las estadisticas - Stat
	 * */
	@Test
	public void ServiceStatsTest() {	
		DnaService dnaService = mock(DnaService.class);
		when(dnaService.countHumans()).thenReturn(100);
		when(dnaService.countMutants()).thenReturn(40);
		statService = new StatService(dnaService);
		
		StatDto stats  = statService.getStats();

		assertThat(stats.getCountMutantDna()).isEqualTo(40);

	}
	
	/*
	 * Uso del servicio Mutant
	 * */
	@Test
	public void isMutantTest() {	
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		MatrixService matrixService = new MatrixService();
		DnaRepository dnaRepository = new DnaRepository(mock(MongoOperations.class));
		DnaService dnaService = new DnaService(dnaRepository);
		mutantService = new MutantService(matrixService, dnaService);
		boolean isMutant = mutantService.isMutant(dnaMutant);
		assertTrue(isMutant);

	}
	
	/*
	 * Metodos mongo db - findAll
	 * */
	@Test
	public void findAllTest() {	
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		MongoOperations mongoDb = mock(MongoOperations.class);
		List<Dna> listDna = new ArrayList<>();
	    Dna dna = new Dna();
	    dna.setDna(dnaMutant);
	    dna.setMutant(true);
	    listDna.add(dna);
	    
		when(mongoDb.findAll(Dna.class)).thenReturn(listDna);
		DnaRepository dnaRepository = new DnaRepository(mongoDb);
		
		assertThat(dnaRepository.findAll().get().size()).isEqualTo(0);

	}
	
	/*
	 * Metodos mongo db - Count
	 * */
	@Test
	public void findACountTest() {	
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		MongoOperations mongoDb = mock(MongoOperations.class);
		List<Dna> listDna = new ArrayList<>();
	    Dna dna = new Dna();
	    dna.setDna(dnaMutant);
	    dna.setMutant(true);
	    listDna.add(dna);
	    
		when(mongoDb.findAll(Dna.class)).thenReturn(listDna);
		DnaRepository dnaRepository = new DnaRepository(mongoDb);
		int findCountMutants = dnaRepository.countMutants();
		
		assertThat(dnaRepository.countHumans()).isEqualTo(0);

	}
	
	/*
	 * Metodos mongo db - delete
	 * */
	@Test
	public void deleteTest() {	
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		MongoOperations mongoDb = mock(MongoOperations.class);
		List<Dna> listDna = new ArrayList<>();
	    Dna dna = new Dna();
	    dna.setDna(dnaMutant);
	    dna.setMutant(true);
	    listDna.add(dna);
	    
		when(mongoDb.findAll(Dna.class)).thenReturn(listDna);
		DnaRepository dnaRepository = new DnaRepository(mongoDb);
		
		dnaRepository.deleteDna("1");
		
		assertThat(dnaRepository.findOne("1")).isEqualTo(Optional.empty());

	}
	
	/*
	 * Metodos mongo db - Update
	 * */
	@Test
	public void UpdateTest() {	
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		MongoOperations mongoDb = mock(MongoOperations.class);
		List<Dna> listDna = new ArrayList<>();
	    Dna dna = new Dna();
	    dna.setDna(dnaMutant);
	    dna.setMutant(true);
	    listDna.add(dna);
	    
		when(mongoDb.findAll(Dna.class)).thenReturn(listDna);
		DnaRepository dnaRepository = new DnaRepository(mongoDb);
		
		dnaRepository.updateDna(dna);
		
		assertThat(dnaRepository.findOne("1")).isEqualTo(Optional.empty());

	}
	
	
}
