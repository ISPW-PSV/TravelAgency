/**
 * 
 */
package it.ispw.psv.travelagency;

import org.joda.time.DateTime;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
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
	 */
	private User user;
	
	/**
	 * 
	 */
	private PaymentMethod paymentMethod;

	public Client(DateTime birthdate, String mailAddress, String name, String phoneNumber, String surname, Gender gender, PhysicalAddress physicalAddress, Login login, String hashcode) {
		
		super(birthdate, mailAddress, name, phoneNumber, surname, gender, physicalAddress, login);
		
		this.hashCode = hashcode;
	}

	/**
	 *  
	 */
	public void resendVerificationMail() {
		// begin-user-code
		// TODO Auto-generated method stub
		MailProvider mp = new MailProvider();
		mp.sendVerificationMail(mailAddress);
		// end-user-code
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