/**
 * IRouteDao.java
 *
 * @description: Contrato de consultas de rutas.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/


package com.meli.challenge.mutant.infrastructure.dao.contract;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;



@Repository
public interface IRouteDao {
	

	void finishRoute(long routeId,LocalDateTime date);
	void updateShipps(long routeId, int shipps);
	void updateLoads(long routeId, int loads);
	int activateRoutes(List<Long> routes);
	int deleteRoutes(List<Long> routes);

}
