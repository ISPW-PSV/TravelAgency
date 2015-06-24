/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

/**
 * Bean for Client.  
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ClientBean extends PersonBean {

	private Boolean confirmed;
	private String hashCode;
	private User user;
	private PaymentMethod paymentMethod;

	public Boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	
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
}