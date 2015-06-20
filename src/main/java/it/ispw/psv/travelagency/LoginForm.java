package it.ispw.psv.travelagency;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;

public class LoginForm {

	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(LoginForm.class.getName()); 
	
	
	/**
	 * Regular expression for email check
	 */
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * @throws ValidateException 
	 *  
	 */
	public static void Login(String mailAddress, String password) throws ValidateException {
		// TODO: try with exception for validate
		
		// Check syntactical errors
		try {
			validateEmail(mailAddress);
		} catch (ValidateException exception) {
			LOGGER.info(exception.getMessage());
			throw exception;
		}
		new LoginController(mailAddress, password);
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

}
