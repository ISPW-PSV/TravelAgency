/**
 * 
 */
package it.ispw.psv.travelagency;

import javax.persistence.Embeddable;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Embeddable
public class Login {
	/** 
	 * 
	 */
	private String username;

	/**
	 *  
	 */
	private String password;

	protected Login() {
		/**
		 * Empty constructor for JPA persistence request
		 */
	}
	
	public Login(String username, String password) {
		if (checkPassword(password)) {
			this.username = username;
			//this.password = encode(password);
			this.password = password;
		} else {
			// TODO: throw passwordException
		}
	}
	
	/**
	 *  
	 * @param password
	 */
	private Boolean checkPassword(String password) {
		return password.length() >= 8;  //TODO  try to use this regex: http://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
	}
}