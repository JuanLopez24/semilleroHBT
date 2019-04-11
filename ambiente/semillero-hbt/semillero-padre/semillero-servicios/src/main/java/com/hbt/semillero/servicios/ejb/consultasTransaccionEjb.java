/**
 * consultasTransaccionEjb.java
 */
package com.hbt.semillero.servicios.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Cindy Johanna Castaño Yepes <X555Q@heinsohn.com.co>
 * @version 
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class consultasTransaccionEjb {
	@Resource
	private UserTransaction utx;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void modificacion() {
		
		try {
			utx.begin();
			
			entityManager.createQuery("UPDATE");
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
