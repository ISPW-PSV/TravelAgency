/**
 * 
 */
package it.ispw.psv.travelagency;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ClientDAO {
	
	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(ClientDAO.class.getName()); 
	
	/** 
	 * 
	 * @param username
	 * @return
	 */
	public static Boolean findByEmail(String email) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	
	/** 
	 * 
	 * @param hashCode
	 */
	public static void setConfirmation(String hashCode) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * 
	 * @param client
	 */
	public static void saveClient(Client client) {
		EntityManager entityManager = JPAInitializer.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(client);
		transaction.commit();

		LOGGER.info("User succesfull registered!");
	}

	/** 
	 * 
	 * @param hashCode
	 */
	private static void findByHashCode(String hashCode) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}