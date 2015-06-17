/**
 * 
 */
package it.ispw.psv.travelagency;

import java.util.List;

import javax.persistence.EntityManager;

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
		entityManager.persist(client);
		entityManager.getTransaction().commit();
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