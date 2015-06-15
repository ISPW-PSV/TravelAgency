/**
 * 
 */
package it.ispw.psv.travelagency;

import org.joda.time.DateTime;

/** 
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PersonBean {
	//TODO: Read this http://stackoverflow.com/questions/27235033/using-joda-time-with-jpa-hibernate-and-spring in order to use with JPA
	private DateTime birthdate;
	private String mailAddress;
	private String name;
	private String phoneNumber;
	private String surname;
	private Gender gender;
	private PhysicalAddress physicalAddress;
	private Login login;

	public DateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public PhysicalAddress getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(PhysicalAddress physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}