/**
 * 
 */
package it.ispw.psv.travelagency;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;

/** 
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RegistrationForm {
	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(RegistrationForm.class.getName()); 
	
	/**
	 * Regular expression for the email checks
	 */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 *  
	 */
	public static void registration(String mailAddress, String name, String phoneNumber, String surname, Gender gender, DateTime birthdate, PhysicalAddress physicalAddress, Login login) {
		// TODO: try with exception for validate
		
		// Check syntactical errors
		if (validateEmail(mailAddress) && validatePhoneNumber(phoneNumber) && validateBirthdate(birthdate)) {
			// Now check if the user is already registered
			Registration.validate(mailAddress, name, phoneNumber, surname, gender, birthdate, physicalAddress, login);
		} else {
		}
	}

	/**
	 * This method checks if the email address is valid using a regular expression.
	 * @param email: the email address to check.
	 * @return true if it is valide and false otherwise. 
	 */
	private static Boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		Boolean isValid = matcher.matches();
		
		LOGGER.info(isValid ? "Valide email" : "Not valid email");
		
		return isValid;  // TODO: return false or thrown exception?
	}

	/**
	 * This method checks if the phone number is valid.
	 * @param phoneNumber: the phone number to check.
	 * @return true if it is valide and false otherwise.
	 */
	private static Boolean validatePhoneNumber(String phoneNumber) {
		// TODO Crate method
		return null;
	}

	/**
	 * This method checks if the birthdate of the user allows him to be considered adult.
	 * @param birthDate: the birthdate of the user.
	 * @return true if the user is adult and false otherwise.
	 */
	private static boolean validateBirthdate(DateTime birthDate) {
		// Get the user's birth year
		int year = birthDate.getYear();
		
		// Get the year of now
		DateTime now = new DateTime();
		int nowYear = now.getYear();
		
		// Check if the difference is greater than 18 year
		Boolean isAdult = nowYear - year >= 18 ? true : false;
		
		LOGGER.info(isAdult ? "It is an adult" : "It is not an adult");
		
		return isAdult;
	}
}