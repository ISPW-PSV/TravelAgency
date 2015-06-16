/**
 * 
 */
package it.ispw.psv.travelagency;

import org.joda.time.DateTime;

/** 
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Person {
	/** 
	 * 
	 */
	//TODO: Read this http://stackoverflow.com/questions/27235033/using-joda-time-with-jpa-hibernate-and-spring in order to use with JPA
	private DateTime birthdate;
	
	/**
	 *  
	 */
	protected String mailAddress;
	
	/**
	 *  
	 */
	private String name;
	
	/**
	 *  
	 */
	private String phoneNumber;
	
	/** 
	 * 
	 */
	private String surname;
	
	/**
	 *  
	 */
	private Gender gender;

	/**
	 *  
	 */
	private PhysicalAddress physicalAddress;

	/**
	 *  
	 */
	private Login login;

	public Person(DateTime birthdate, String mailAddress, String name, String phoneNumber, String surname, Gender gender, PhysicalAddress physicalAddress, Login login) {
		
		this.birthdate = birthdate;
		this.mailAddress = mailAddress;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.surname = surname;
		this.gender = gender;
		this.physicalAddress = physicalAddress;
		this.login = login;
	}
	
	
}