/**
 * IRouteState.java
 *
 * @description: Interfaz que implementa la gestión de estados una ruta.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/
package com.meli.challenge.mutant.domain.base;

/**
 * Contrato que gestiona los estado de una ruta.
 * @author SERGIO SALAZAR.
 *
 */
public interface IRouteState {
	
	/**
	 * Ejecuta el cambio de estado para una programacion de ruta.
	 */
	void schedule();
	
	/**
	 * Ejecuta el cambio de estado para un inicio de ruta.
	 */
	void start();
	
	/**
	 * Ejecuta el cambio de estado para una finalización de ruta.
	 */
	void finish();
}
