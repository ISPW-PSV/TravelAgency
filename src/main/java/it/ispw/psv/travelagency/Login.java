/**
 * 
 */
package it.ispw.psv.travelagency;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Login {
	/** 
	 * 
	 */
	private String username;

	/**
	 *  
	 */
	private String password;

	public Login(String username, String password) {
		if (checkPassword(password)) {
			this.username = username;
			this.password = password;
		} else {
			// TODO: thwron passwordException
		}
	}
	
	/**
	 *  
	 * @param password
	 */
	private Boolean checkPassword(String password) {
		return password.length() >= 8;  //TODO for now simple lenght test
	}
}