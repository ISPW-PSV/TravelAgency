package it.ispw.psv.travelagency;

import java.util.logging.Logger;

public class PersonDAO {

	/**
	 * Static logger instance
	 */
	@SuppressWarnings("unused")
	private final static Logger LOGGER = Logger.getLogger(PersonDAO.class.getName()); 
	
	/** 
	 * 
	 * @param username
	 * @return
	 */
	
	public PersonDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static Boolean findByEmailandPassword(String email, String Password) {
		// begin-user-code
		// TODO Auto-generated method stub
		
		//find by mail
		//exception if not found
		//oldpass = get password
		// return decode(password, oldpass);
		// 
		//NOTE: On all tables. Not necessarily a single call to check both mail and password.
		//NOTE: Maybe change the return to String/int, and return the Role? Somehow, we must enforce the privileges and limit the views according to the role they signed in as.
		
		
		
		
		return null;
		// end-user-code
	}


}
