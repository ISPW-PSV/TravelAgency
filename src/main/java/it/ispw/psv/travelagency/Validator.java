package it.ispw.psv.travelagency;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;

public class Validator {
	
	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(RegistrationForm.class.getName()); 
	
	/**
	 * Regular expression for email and phone number checks
	 */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String MOBILE_PHONE_PATTERN = "^([+]39)?((38[{8,9}|0])|(34[{7-9}|0])|(36[6|8|0])|(33[{3-9}|0])|(32[{8,9}]))([\\d]{7})$";
	private static final String FIX_PHONE_PATTERN = "^([0-9]*\\-?\\ ?\\/?[0-9]*)$";
	
	/**
	 * This method checks if the email address is valid using a regular expression.
	 * @param email: the email address to check.
	 * @return true if the email is valid, false otherwise.
	 */
	public static Boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		Boolean isValid = matcher.matches();
		
		LOGGER.info(isValid ? "Valide email" : "Not valid email");
		
		return isValid;
	}

	/**
	 * This method checks if the phone number is valid.
	 * @param phoneNumber: the phone number to check.
	 * @return true if the phone number is valid, false otherwise.
	 */
	public static Boolean validatePhoneNumber(String phoneNumber) {
		Pattern mobilePattern = Pattern.compile(MOBILE_PHONE_PATTERN);
		Pattern fixPattern = Pattern.compile(FIX_PHONE_PATTERN);
		
		Matcher mobileMatcher = mobilePattern.matcher(phoneNumber);
		Matcher fixMatcher = fixPattern.matcher(phoneNumber);

		Boolean isValidMobile = mobileMatcher.matches();
		Boolean isValidFix = fixMatcher.matches();
		
		LOGGER.info((isValidMobile && isValidFix) ? "Valide phone number" : "Not valid phone number");

		return (isValidMobile || isValidFix);
	}

	/**
	 * This method checks if the birthdate of the user allows him to be considered adult.
	 * @param birthDate: the birthdate of the user.
	 * @return true if the client is an adult, false otherwise.
	 */
	public static Boolean validateBirthdate(DateTime birthDate) {
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
	
	/**
	 * Getter for jsp page.
	 * @return regex for email.
	 */
	public static String getEmailPattern() {
		return EMAIL_PATTERN;
	}
	
	/**
	 * Getter for jsp page.
	 * @return regex for mobile phone.
	 */
	public static String getMobilePhonePattern() {
		return MOBILE_PHONE_PATTERN;
	}
	
	/**
	 * Getter for jsp page.
	 * @return regex for fix phone.
	 */
	public static String getFixPhonePattern() {
		return FIX_PHONE_PATTERN;
	}
}
