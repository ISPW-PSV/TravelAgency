/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

/**
 * This enumeration si usefull with ValidateException in order to recognize the type of the exception.
 */
public enum ValidateType {
	/**
	 * Enum for email address.
	 */
	EmailAddress,
	
	/**
	 * Enum for phone number.
	 */
	PhoneNumber,
	
	/**
	 * Enum for birthdate.
	 */
	Birthdate;
}
