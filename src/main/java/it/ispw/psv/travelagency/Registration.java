/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import java.util.logging.Logger;

import org.joda.time.DateTime;

/**
 * Registration Controller. 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Registration {
	
	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(Registration.class.getName()); 
	
	/**
	 * This is the main method of the Registration controller. Calling this method, the controller checks if the user is  not
	 * already registered and, in case it is a new one, send a confirmation email (before it generates a hashcode in order 
	 * to make safer the confirmation system) and register the user into the system.
	 * @param mailAddress: the email address of the user.
	 * @param name: the name of the user.
	 * @param phoneNumber: the phone number of the user.
	 * @param surname: the surname of the user.
	 * @param gender: the gender of the user.
	 * @param birthdate: the birthdate of the user.
	 * @param physicalAddress: the physical address of the user.
	 * @param login: the login of the user.
	 * @throws UserAlreadyRegisteredException: means that the user is already registered.
	 */
	public static void validate(String mailAddress, String name, String phoneNumber, String surname, Gender gender, DateTime birthdate, PhysicalAddress physicalAddress, Login login, User user, PaymentMethod  paymentMethod) throws UserAlreadyRegisteredException {
		if (ClientDAO.findByEmail(mailAddress) == null) {
			
			LOGGER.info("User not registered!");
			// Generate the hash code to send into email.
			String hashCode = generateHashCode(mailAddress);
			
			// TODO: use thread here.
			MailProvider mailProvider = new MailProvider();
			mailProvider.sendVerificationMail(mailAddress, hashCode);

			Client client = new Client(birthdate, mailAddress, name, phoneNumber, surname, gender, physicalAddress, login, user, hashCode, paymentMethod);
			ClientDAO.saveClient(client);
		} else {
			throw new UserAlreadyRegisteredException();
		}
	}

	/**
	 * This method generates a unique hashcode from the email address.
	 * @param email: the email address of the user.
	 * @return a unique string.
	 */
	private static String generateHashCode(String email) {
		String hashCode = new String(email);
		hashCode.hashCode();
		return hashCode;
	}
}