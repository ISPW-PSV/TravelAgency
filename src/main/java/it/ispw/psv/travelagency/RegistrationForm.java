/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import java.util.logging.Logger;

import org.joda.time.DateTime;

/** 
 * Registration View.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RegistrationForm {
	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(RegistrationForm.class.getName()); 
	
	/**
	 * This is the main method of the RegistrationForm view. Calling this method, the view checks syntactical errors and 
	 * then passes the data to the control.
	 * @param mailAddress: the email address of the user.
	 * @param name: the name of the user.
	 * @param phoneNumber: the phone number of the user.
	 * @param surname: the surname of the user.
	 * @param gender: the gender of the user.
	 * @param birthdate: the birthdate of the user.
	 * @param physicalAddress: the physical address of the user.
	 * @param login: the login of the user.
	 * @throws ValidateException: means that there is something wrong with the data passed, i.e. the email is not correct,
	 * 		   the phone number is not correct or the user is too young to register.
	 * @throws UserAlreadyRegisteredException: means that the user is already registered.
	 */
	public static void registration(String mailAddress, String name, String phoneNumber, String surname, Gender gender, DateTime birthdate, PhysicalAddress physicalAddress, Login login, User user, PaymentMethod paymentMethod) throws ValidateException, UserAlreadyRegisteredException {
		// Check syntactical errors
		try {
			
			if(!Validator.validateEmail(mailAddress)) {
				throw new ValidateException(ValidateType.EmailAddress);
			};
			if(!Validator.validatePhoneNumber(phoneNumber)) {
				throw new ValidateException(ValidateType.PhoneNumber);
			};
			if(!Validator.validateBirthdate(birthdate)) {
				throw new ValidateException(ValidateType.Birthdate);
			};
			
			// Now check if the user is already registered
			Registration.validate(mailAddress, name, phoneNumber, surname, gender, birthdate, physicalAddress, login, user, paymentMethod);
		} catch (ValidateException exception) {
			LOGGER.info(exception.getMessage());
			throw exception;
		} catch (UserAlreadyRegisteredException exception) {
			LOGGER.info(exception.getMessage());
			throw exception;
		}
	}
}