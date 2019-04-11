/**
 * concultasBean.java
 */
package com.hbt.semillero.servicios.ejb;



import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.personaDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;


/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Juan Andres Lopez Osorio 
 * @version 
 */
@Stateless
public class concultasBean implements IConsultasBeanLocal {
	@PersistenceContext
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarca() {
		return entityManager.createQuery("Select ma FROM Marca ma").getResultList();
		//List<Object[]> marcaDos=entityManager.createNativeQuery("Select * FROM Marca ma");
	}
	public List<Linea> consultarLinea(Long idMarca){
		Query consulta=entityManager.createQuery("Select ln FROM Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca");
		consulta.setParameter("idMarca", idMarca);
		return consulta.getResultList();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(personaDTO personaDTO){
		Persona persona=new Persona();
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setEdad(personaDTO.getEdad());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		
		entityManager.persist(persona);
		
		if(personaDTO.isComprador()) {
			Comprador comprador=new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);
		}if(personaDTO.isVendedor()) {
			Vendedor vendedor= new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
		}
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Persona> consultarPersona(String tipoIdentificacion, String numeroIdentificacion) {
		Query consulta=entityManager.createQuery("Select per FROM Persona per where per.tipoIdentificacion=:tipoIdentificacion and per.numeroIdentificacion=:numeroIdentificacion");
		consulta.setParameter("tipoIdentificacion", tipoIdentificacion);
		consulta.setParameter("numeroIdentificacion", numeroIdentificacion);
		return consulta.getResultList();
	}

}
