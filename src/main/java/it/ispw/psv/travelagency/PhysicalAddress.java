/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import javax.persistence.Embeddable;

/** 
 * This class represents a physical address of a person.
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Embeddable
public class PhysicalAddress {
	/** 
	 * The address of the person. 
	 */
	private String address;

	/**
	 * The house number.
	 */
	private String number;

	/**
	 * The city.
	 */
	private String city;
	
	/** 
	 * The postal code.
	 */
	private Integer postalCode;

	/**
	 * The province.
	 */
	private String province;

	/**
	 * The province code.
	 */
	private String provinceCode;
	
	/**
	 * Empty constructor for JPA persistence request
	 */
	protected PhysicalAddress() {
	}
	
	/**
	 * This is the constructor.
	 * @param address: the address of the house.
	 * @param number: the house number.
	 * @param city: the city.
	 * @param postalCode: the postal code.
	 * @param province: the province.
	 * @param provinceCode: the province code.
	 */
	public PhysicalAddress(String address, String number, String city, String postalCode, String province, String provinceCode) {
		super();
		
		this.address = address;
		this.number = number;
		this.city = city;
		this.postalCode = Integer.parseInt(postalCode);
		this.province = province;
		this.provinceCode = provinceCode;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %04d %s %s", address, city, number, postalCode, province, provinceCode);
	}
}