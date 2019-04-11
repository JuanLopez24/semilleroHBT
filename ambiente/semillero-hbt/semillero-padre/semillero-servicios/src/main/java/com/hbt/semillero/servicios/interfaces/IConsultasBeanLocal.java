/**
 * IConsultasBeanLocal.java
 */
package com.hbt.semillero.servicios.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.personaDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author  Juan Andres Lopez Osorio 
 * @version 
 */
@Local
public interface IConsultasBeanLocal {
	public List<Marca> consultarMarca();
	public List<Linea> consultarLinea(Long idMarca);
	public void crearPersona(personaDTO personaDTO);
	public List<Persona> consultarPersona(String tipoIdentificacion, String numeroIdentificacion);

}
