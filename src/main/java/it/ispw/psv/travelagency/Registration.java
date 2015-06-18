/**
 * 
 */
package it.ispw.psv.travelagency;

import org.joda.time.DateTime;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Registration {
	/**
	 *  
	 */
	public static void validate(String mailAddress, String name, String phoneNumber, String surname, Gender gender, DateTime birthdate, PhysicalAddress physicalAddress, Login login) {
		if (ClientDAO.findByEmail(mailAddress) == null) {
			String hashCode = generateHashCode(mailAddress);
			
			// TODO: use thread here.
			MailProvider mailProvider = new MailProvider();
			

			Client client = new Client(birthdate , mailAddress, name, phoneNumber, surname, gender, physicalAddress, login, hashCode);
			ClientDAO.saveClient(client);
		} else {
			//TODO: thrown userAlreadyRegistered exception
		}
	}

	/**
	 * This method generates a unique hashcode from the email address.
	 * @param email: the email address of the user.
	 * @returna a unique string.
	 */
	private static String generateHashCode(String email) {
		String hashCode = new String(email);
		hashCode.hashCode();
		return hashCode;
	}
}