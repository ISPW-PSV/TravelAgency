/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class initializes a static entity manager of JPA for the entire project.
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
	
	/**
	 * Initializes all the stuffs for JPA.
	 */
	private JPAInitializer() {
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
	 * Getter for the instance of entityManager. This is a singleton. 
	 * @return the static entity manager instance.
	 */
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			new JPAInitializer();
		}
		return entityManager;
	}
}