/**
 * 
 */
package it.ispw.psv.travelagency;

/** 
 * 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PhysicalAddress {
	/** 
	 * 
	 */
	private String address;

	/**
	 *  
	 */
	private String number;

	/**
	 *  
	 */
	private String city;
	
	/** 
	 * 
	 */
	private Integer postalCode;

	/**
	 *  
	 */
	private String province;

	/**
	 *  
	 */
	private String provinceCode;
	
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