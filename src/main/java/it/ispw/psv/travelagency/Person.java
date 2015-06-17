/**
 * 
 */
package it.ispw.psv.travelagency;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/** 
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	/** 
	 * 
	 */
	//TODO: Read this http://stackoverflow.com/questions/27235033/using-joda-time-with-jpa-hibernate-and-spring in order to use with JPA
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime birthdate;
	
	/**
	 *  
	 */
	@Id
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
	@Enumerated(EnumType.STRING)
	private Gender gender;

	/**
	 *  
	 */
	@Embedded
	private PhysicalAddress physicalAddress;

	/**
	 *  
	 */
	@Embedded
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