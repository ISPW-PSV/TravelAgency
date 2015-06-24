package it.ispw.psv.travelagency;

import java.util.logging.Logger;

import org.joda.time.DateTime;

public class LoginController {

	/**
	 * Static logger instance
	 */
	private final static Logger LOGGER = Logger.getLogger(LoginController.class.getName()); 
	
	/**
	 *  
	 */
	
	public LoginController(String mailAddress, String password) {
		if (PersonDAO.findByEmailandPassword(mailAddress, password) != null) {
			
			//TODO: Change status and give privileges
		}
		else{
			LOGGER.info("User not registered!");
			new Exception("User not found. Invalid E-Mail or password.");
		}
	}
	


}
