/*
 * Realized for the course of ISPW at University of Roma Tor Vergata.
 * Claudio Pastorini, Omar Shalby and Federico Vagnoni.
 * A.A. 2014/2015
 */
package it.ispw.psv.travelagency;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Embeddable;

/**
 * This class represents the login with username and encrypted password. 
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Embeddable
public class Login {
	/** 
	 * The username of the login.
	 */
	@SuppressWarnings("unused")
	private String username;

	/**
	 * The password of the login.
	 */
	@SuppressWarnings("unused")
	private String password;
	
	/**
	 * Empty constructor for JPA persistence request
	 */
	protected Login() {
	}
	
	/**
	 * Main constructor. The password is firstly checked to be longer and after
	 * encrypted with SHA-1 algorithm.
	 * @param username: username of the login.
	 * @param password: the password of the login.
	 */
	public Login(String username, String password) {
		if (checkPassword(password)) {
			this.username = username;
<<<<<<< HEAD
			this.password = hashString(password);
		} else {
			new Exception("The password is too short. Plase insert one that is almost composed by 8 charachters.");
=======
			//this.password = encode(password);
			this.password = password;
		} else {
			// TODO: throw passwordException
>>>>>>> 1a91f4f7bca2b7e0627c9559a3bdb1746357c08c
		}
	}
	
	/**
	 * This method checks if the password lenght is enough for the security.
	 * @param password the password to check.
	 * @return true in case of success, false otherwise.
	 */
	private Boolean checkPassword(String password) {
		return password.length() >= 8;
	}
	
	/**
	 * This method converts string into SHA-1 hash.
	 * @param string: the string to convert.
	 * @return the string in SHA-1 hash.
	 */
	private static String hashString(String string) {
		byte[] hashedBytes = null;
		try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            hashedBytes = digest.digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException exception) {
			exception.printStackTrace();
		}
		return convertByteArrayToHexString(hashedBytes);
	}
 
	/**
	 * This method convert a byte array into hexadecimal string.
	 * @param arrayBytes: the array bites to convert.
	 * @return the hexadecimal string.
	 */
    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}