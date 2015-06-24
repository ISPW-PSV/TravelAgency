/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * This class represents a user with his cookie.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
public class User {
	/**
	 * The id of the user.
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * The cookie of the user. 
	 */
	private String cookie;

	/**
	 * This method return the cookie.
	 * @return the cookie of the user.
	 */
	public String getCookie() {
		return this.cookie;
	}

	/**
	 * This method sets the cookie.
	 * @param cookie the cookie of the user.
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
}