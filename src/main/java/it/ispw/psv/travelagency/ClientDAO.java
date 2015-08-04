/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * This is the Data Access Object for the client.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ClientDAO {
	/**
	 * Static logger instance.
	 */
	private final static Logger LOGGER = Logger.getLogger(ClientDAO.class.getName()); 
	
	/** 
	 * This method checks, using his email address, if a user is already registered.
	 * @param email: the email of the user to checks.
	 * @return the Client found, null otherwise.
	 */
	public static Client findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * This method allows to set a user as confirmed.
	 * @param hashCode: the hashcode of the user to set confirmed.
	 */
	public static void setConfirmation(String hashCode) {
		// TODO Auto-generated method stub
	}

	/** 
	 * This method saves a client into the database.
	 * @param client: the client to save into the database.
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
	 * This method finds if a user is already registered using his hashcode.
	 * @param email: the email of the user to checks.
	 * @return the Client found, null otherwise.
	 */
	public static Client findByHashCode(String hashCode) {
		// begin-user-code
		return null;
	}
}