/**
 * 
 */
package it.ispw.psv.travelagency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
public class User {
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;
	/**
	 *  
	 */
	private String cookie;

	/**
	 *  
	 * @return
	 */
	public String getCookie() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/**
	 *  
	 * @param cookie
	 */
	public void setCookie(String cookie) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}