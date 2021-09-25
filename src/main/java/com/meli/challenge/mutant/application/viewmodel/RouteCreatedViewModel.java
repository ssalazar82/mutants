/**
 * RouteCreatedViewModel.java
 *
 * @description: ViewModel que encapsula la respuesta a cliente de la creación de una ruta.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/
package com.meli.challenge.mutant.application.viewmodel;

public class RouteCreatedViewModel {
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}
