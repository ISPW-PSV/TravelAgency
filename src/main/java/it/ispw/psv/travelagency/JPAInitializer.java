package it.ispw.psv.travelagency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class initializes a static entity manager of JPA for the entire project.
 * 
 * @author Manuel Mastrofini
 */
public class JPAInitializer {
	/**
	 * Static field for entity manager. 
	 */
	private static EntityManager entityManager;
	/**
	 * Static field for entity manager factory.
	 */
	private static EntityManagerFactory entityManagerFactory;
	
	//TODO Does it should be a singleton?
	/**
	 * Initializes all the stuffs for JPA.
	 */
	public static void initJPA() {
		entityManagerFactory = Persistence.createEntityManagerFactory("TravelAgency");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	/**
	 * Close all the the stuffs used for JPA.
	 */
	public static void shutdown() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
	/**
	 * Getter for the entityManager initialized before.
	 * @return the static entity manager instance.
	 */
	public static EntityManager getEntityManager() {
		return entityManager;
	}
}