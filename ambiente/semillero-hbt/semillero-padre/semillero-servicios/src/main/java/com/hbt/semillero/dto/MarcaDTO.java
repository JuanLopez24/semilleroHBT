/**
 * MarcaDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author  Juan Andres Lopez Osorio 
 * @version 
 */
public class MarcaDTO implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idMarca;

	private String nombre;

	/**
	 * Metodo encargado de retornar el valor del atributo idMarca
	 * @return El idMarca asociado a la clase
	 */
	public Long getIdMarca() {
		return idMarca;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo idMarca
	 * @param idMarca El nuevo idMarca a modificar.
	 */
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
