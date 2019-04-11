/**
 * ResultadoDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Cindy Johanna Castaño Yepes <X555Q@heinsohn.com.co>
 * @version 
 */
public class ResultadoDTO implements Serializable {
	
	private boolean exitoso;
	private String mensaje;
	/**
	 * Metodo encargado de retornar el valor del atributo exitoso
	 * @return El exitoso asociado a la clase
	 */
	public boolean isExitoso() {
		return exitoso;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo exitoso
	 * @param exitoso El nuevo exitoso a modificar.
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo mensaje
	 * @return El mensaje asociado a la clase
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo mensaje
	 * @param mensaje El nuevo mensaje a modificar.
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
