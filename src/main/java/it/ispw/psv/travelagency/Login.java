/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import javax.persistence.Embeddable;

/**
 * This class represents the login with username and encrypted password. 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Embeddable
public class Login {
	/** 
	 * The username of the login.
	 */
	@SuppressWarnings("unused")
	private String username;

	/**
	 * The password of the login.
	 */
	@SuppressWarnings("unused")
	private String password;
	
	/**
	 * Empty constructor for JPA persistence request
	 */
	protected Login() {
	}
	
	/**
	 * Main constructor. The password is first checked to be longer than a set minimum and then crypted
	 * @param username: username of the login.
	 * @param password: the password of the login.
	 */
	public Login(String username, String password) {
		if (checkPassword(password)) {
			
			this.username = username;
			this.password = (new Crypter()).encode(password);
		} else {
			new Exception("The password is too short. Please insert one that is composed by at least 8 characters.");
		}
//		} else {
//			// TODO: throw passwordException
//		}
	}
	
	/**
	 * This method checks if the password length is enough for the security.
	 * @param password: the password to check.
	 * @return true in case of success, false otherwise.
	 */
	private Boolean checkPassword(String password) {
		return password.length() >= 8;
	}
	
	
}