/**
 * serviciosREST.java
 */
package com.hbt.semillero.servicios.rest;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.personaDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author  Juan Andres Lopez Osorio 
 * @version 
 */
@Path("/ServiciosRest")
public class ServiciosRest {

	@EJB
	private IConsultasBeanLocal consultasBean;
	
	@GET
	@Path("/consultarMarcas")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas(){
		List<Marca> marcas=consultasBean.consultarMarca();
		List<MarcaDTO> retorno=new ArrayList<>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDTO=construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}
		return retorno;
	}
	
	@GET
	@Path("/consultarLinea")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLinea(@QueryParam(value="idMarca") Long idMarca){
		List<Linea> lineas=consultasBean.consultarLinea(idMarca);
		List<LineaDTO> retorno=new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO= new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setCilindraje(linea.getCilindraje());
			lineaDTO.setNombre(linea.getNombre());
			MarcaDTO marcaDTO=construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);
			retorno.add(lineaDTO);
		}
		return retorno;
	}
	
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO= new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		
		return marcaDTO;
	}
	
	@POST
	@Path("/crearPersona")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(personaDTO personaDTO){
		ResultadoDTO retorno=new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);
		} catch (Exception e) {
			// TODO: handle exception
			retorno.setExitoso(true);
			retorno.setMensaje("No se pudo ingresar usuario");
		}
		return retorno;
	}
	@GET
	@Path("/consultarPersona")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<personaDTO> consultarPersona(@QueryParam(value="tipoIdentificacion") String tipoIdentificacion, @QueryParam(value="numeroIdentificacion") String numeroIdentificacion){
		List<Persona> persona=consultasBean.consultarPersona(tipoIdentificacion, numeroIdentificacion);
		List<personaDTO> retorno=new ArrayList<>();
		for (Persona perso : persona) {
			personaDTO personaDTO=new personaDTO();
			personaDTO.setNombres(perso.getNombres());
			personaDTO.setApellidos(perso.getApellidos());
			personaDTO.setTipoIdentificacion(perso.getTipoIdentificacion());
			personaDTO.setNumeroIdentificacion(perso.getNumeroIdentificacion());
			personaDTO.setNumeroTelefonico(perso.getNumeroTelefonico());
			personaDTO.setEdad(perso.getEdad());
			personaDTO.setIdPersona(perso.getIdPersona());
			retorno.add(personaDTO);
		}
		return retorno;
	}
}
