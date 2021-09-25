/**
 * IShippingState.java
 *
 * @description: Interfaz que implementa la gestión de estados de un despacho.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/
package com.meli.challenge.mutant.domain.base;

/**
 * Contrato que gestiona los estado de un despacho.
 * @author SERGIO SALAZAR.
 *
 */
public interface IShippingState {
	
	/**
	 * Ejecuta el cambio de estado cuando se programa un despacho.
	 */
	void schedule();
	
	/**
	 * Ejecuta el cambio de estado de despacho cuando se inicia la ruta.
	 */
	void setOnRoute();
	
	/**
	 * Ejecuta el cambio de estado de un despacho cuando se llega a un punto de entrega.
	 */
	void arrive();
	
	/**
	 * Ejecuta el cambio de estado de un despacho cuando se entrega el producto.
	 */
	void deliver();
	
	/**
	 * Ejecuta el cambio de estado de un despacho cuando se rechaza la entrega.
	 */
	void notDeliver();
	
	/**
	 * Ejecuta el cambio de estado de un despacho cuando se realiza una entrega parcial del prodcucto.
	 */
	void deliverPartially();
}
