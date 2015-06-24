/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

/**
 * This class represents a user with his cookie.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Client extends Person {
	/**
	 * A boolean that see if a user is confirmed or not.  
	 */
	@SuppressWarnings("unused")
	private Boolean confirmed;
	
	/**
	 * The hash code using the email address.  
	 */
	@SuppressWarnings("unused")
	private String hashCode;

	/**
	 * The user instance with cookie.  
	 */
	@OneToOne
	private User user;
	
	/**
	 * The favourite payment method. 
	 */
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	/**
	 * The constructor that calls first of all the super constructor with all parameters and it sets alse the hashcode, the favorite payment method and the "user" of the client.
	 * @param birthdate: the birthdate of the person.
	 * @param mailAddress: the email address.
	 * @param name: the name.
	 * @param phoneNumber: the phone number.
	 * @param surname: the surname.
	 * @param gender: the gender.
	 * @param physicalAddress: the physical address where the person live.
	 * @param login: the login.
	 * @param hashcode: the hashcode of the email of the client.
	 */
	public Client(DateTime birthdate, String mailAddress, String name, String phoneNumber, String surname, Gender gender, PhysicalAddress physicalAddress, Login login, User user, String hashCode, PaymentMethod paymentMethod) {
		
		super(birthdate, mailAddress, name, phoneNumber, surname, gender, physicalAddress, login);
		
		this.user = user;
		this.hashCode = hashCode;
		this.paymentMethod = paymentMethod;
	}
}