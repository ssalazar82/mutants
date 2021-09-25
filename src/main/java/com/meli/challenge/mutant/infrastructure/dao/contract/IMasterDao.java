/**
 * IMasterDao.java
 *
 * @description: Contrato de consultas sobre la tabla de maestros.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.infrastructure.dao.contract;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meli.challenge.mutant.infrastructure.dto.StatDto;



@Repository
public interface IMasterDao {
	
	List<StatDto> getReasons(String languaje);
	List<StatDto> getReasons(String languaje, long clientId);
	List<StatDto> getReasonsByDefault(String languaje, int management);
	int getIdStatusByManagementTypes(int statusId, int managementType, String language);
	int getIdReason();
	int getIdReasonByShippingStatus();
	int getIdReasonByShippingStatusByReason(int reason);
	int getIdReasonByDescriptionAndClient(String description, long clientId);
	void deleteReasonByShippingStatus(int reasonByShipping);
}
