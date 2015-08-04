/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/** 
 * This class represents a user with his cookie.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
public class Person {
	/** 
	 * The birthdate.
	 */
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime birthdate;
	
	/**
	 * The email address. 
	 */
	@Id
	protected String mailAddress;
	
	/**
	 * The name.  
	 */
	@SuppressWarnings("unused")
	private String name;
	
	/**
	 * The phone number.  
	 */
	@SuppressWarnings("unused")
	private String phoneNumber;
	
	/** 
	 * The surname. 
	 */
	@SuppressWarnings("unused")
	private String surname;
	
	/**
	 * The gender using Gender enumeration.  
	 */
	@Enumerated(EnumType.STRING)
	private Gender gender;

	/**
	 * the physical address where the person live.
	 */
	@Embedded
	private PhysicalAddress physicalAddress;

	/**
	 * The login.
	 */
	@Embedded
	private Login login;

	/**
	 * The constructor.
	 * @param birthdate: the birthdate of the person.
	 * @param mailAddress: the email address.
	 * @param name: the name.
	 * @param phoneNumber: the phone number.
	 * @param surname: the surname.
	 * @param gender: the gender.
	 * @param physicalAddress: the physical address where the person live.
	 * @param login: the login.
	 */
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