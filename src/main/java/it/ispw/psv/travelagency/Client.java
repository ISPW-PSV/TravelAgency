/**
 * 
 */
package it.ispw.psv.travelagency;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Client extends Person {
	/**
	 *  
	 */
	private Boolean isConfirmed;
	
	/**
	 *  
	 */
	private String hashCode;

	/**
	 *  
	 */
	@OneToOne
	private User user;
	
	/**
	 * 
	 */
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	public Client(DateTime birthdate, String mailAddress, String name, String phoneNumber, String surname, Gender gender, PhysicalAddress physicalAddress, Login login, String hashcode) {
		
		super(birthdate, mailAddress, name, phoneNumber, surname, gender, physicalAddress, login);
		
		this.hashCode = hashcode;
	}

	/**
	 *  
	 */
	public void setHashCode() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}