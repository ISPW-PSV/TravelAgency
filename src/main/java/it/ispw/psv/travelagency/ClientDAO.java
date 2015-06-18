/**
 * 
 */
package it.ispw.psv.travelagency;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ClientDAO {
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
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(client);
		tx.commit();
		/*
		 * http://stackoverflow.com/questions/8758166/jpa-no-transaction-is-currently-active
		 * Sbagliavamo nel fare la transazione come era prima. 
		 */
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