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
	 * Regular expression for email and phone number checks
	 */
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String MOBILE_PHONE_PATTERN = "^([+]39)?((38[{8,9}|0])|(34[{7-9}|0])|(36[6|8|0])|(33[{3-9}|0])|(32[{8,9}]))([\\d]{7})$";
	public static final String FIX_PHONE_PATTERN = "^([0-9]*\\-?\\ ?\\/?[0-9]*)$";
	
	/**
	 * @throws ValidateException 
	 *  
	 */
	public static void registration(String mailAddress, String name, String phoneNumber, String surname, Gender gender, DateTime birthdate, PhysicalAddress physicalAddress, Login login) throws ValidateException {
		// TODO: try with exception for validate
		
		// Check syntactical errors
		try {
			validateEmail(mailAddress);
			validatePhoneNumber(phoneNumber);
			validateBirthdate(birthdate);
			// Now check if the user is already registered
			Registration.validate(mailAddress, name, phoneNumber, surname, gender, birthdate, physicalAddress, login);
		} catch (ValidateException exception) {
			throw exception;
		}
	}

	/**
	 * This method checks if the email address is valid using a regular expression.
	 * @param email: the email address to check.
	 * @throws ValidateException in case of it is not valid.
	 */
	private static void validateEmail(String email) throws ValidateException {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		Boolean isValid = matcher.matches();
		
		LOGGER.info(isValid ? "Valide email" : "Not valid email");
		
		if(!isValid) {
			throw new ValidateException(ValidateType.EmailAddress);
		}
	}

	/**
	 * This method checks if the phone number is valid.
	 * @param phoneNumber: the phone number to check.
	 * @throws ValidateException in case of it is not valid.
	 */
	private static void validatePhoneNumber(String phoneNumber) throws ValidateException {
		Pattern mobilePattern = Pattern.compile(MOBILE_PHONE_PATTERN);
		Pattern fixPattern = Pattern.compile(FIX_PHONE_PATTERN);
		
		Matcher mobileMatcher = mobilePattern.matcher(phoneNumber);
		Matcher fixMatcher = fixPattern.matcher(phoneNumber);

		Boolean isValidMobile = mobileMatcher.matches();
		Boolean isValidFix = fixMatcher.matches();
		
		LOGGER.info(isValidMobile || isValidFix ? "Valide phone number" : "Not valid phone number");

		if(!isValidMobile || !isValidFix) {
			throw new ValidateException(ValidateType.PhoneNumber);
		}
	}

	/**
	 * This method checks if the birthdate of the user allows him to be considered adult.
	 * @param birthDate: the birthdate of the user.
	 * @throws ValidateException in case of it is not valid.
	 */
	private static void validateBirthdate(DateTime birthDate) throws ValidateException {
		// Get the user's birth year
		int year = birthDate.getYear();
		
		// Get the year of now
		DateTime now = new DateTime();
		int nowYear = now.getYear();
		
		// Check if the difference is greater than 18 year
		Boolean isAdult = nowYear - year >= 18 ? true : false;
		
		LOGGER.info(isAdult ? "It is an adult" : "It is not an adult");
		
		if(!isAdult) {
			throw new ValidateException(ValidateType.Birthdate);
		}
	}
}