package it.ispw.psv.travelagency;

/**
 * 
 *
 */
public class ValidateException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -468326357153605240L;
	
	/**
	 * 
	 */
	private ValidateType type; 
	
	public ValidateException(ValidateType type) { 
		super();
		
		this.type = type;
	}

	@Override
	public String getMessage() {
		return String.format("There is an error with validation of %s.", type.name());
	} 
	
	/**
	 * 
	 * @return
	 */
	public ValidateType getType() {
		return this.type;
	}
}