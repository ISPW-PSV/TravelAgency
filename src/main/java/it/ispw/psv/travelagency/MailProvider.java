/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

/**
 * This class allows to send e-mail from the system to the users.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MailProvider {

	/**
	 * Default constructor. 
	 */
	public MailProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method sends the confirmation mail.
 	 * @param email: the email of the user. 
	 * @param hashcode: the hashcode of the user.
	 */
	public void sendVerificationMail(String email, String hashcode) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		String link = generateLink(email, hashcode);
		//TODO generate body email
	}

	/**
	 * This method generates a confirmation link from email and hashcode.
	 * @param email: the email of the user. 
	 * @param hashcode: the hashcode of the user.
	 * @return the link generated.
	 */
	private String generateLink(String email, String hashcode) {
		// TODO Auto-generated method stub
		return null;
	}
}