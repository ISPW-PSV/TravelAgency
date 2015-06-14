/**
 * 
 */
package it.ispw.psv.travelagency;

/**
 *  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ClientBean extends PersonBean {
	/**
	 *  
	 */
	private Boolean isConfirmed;
	
	/**
	 *  
	 */
	private String hashCode;

	/** 
	 */
	private User user;
	
	/**
	 * 
	 */
	private PaymentMethod paymentMethod;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	//TODO: see this in order to use enum in jsp http://stackoverflow.com/questions/2240722/can-i-access-the-values-of-an-enum-class-from-a-jsp-using-el
	
}