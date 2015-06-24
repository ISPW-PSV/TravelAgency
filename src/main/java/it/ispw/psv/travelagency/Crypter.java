package it.ispw.psv.travelagency;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//NOTE: Should a class on crypting be commented?

public class Crypter {

	
	//http://stackoverflow.com/questions/1972392/java-pick-a-random-value-from-an-enum
	
	//To get a random value from an enum
	private static final List<CodingEnum> VALUES =
		    Collections.unmodifiableList(Arrays.asList(CodingEnum.values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public Crypter() {
		
		
		

		
	}
	
	public String encode (String pass){
		String meth;
		String res = null;
		 meth = VALUES.get(RANDOM.nextInt(SIZE)).toString(); // Choose a coding method at random
		for(CodingEnum value: VALUES){
			 if (value.toString() == meth){
				 if (meth == "METHOD1"){
					res = method1Encode(pass);
				 }
				 else if (meth == "METHOD2"){
					res = method2Encode(pass);
				 }
				 else if (meth == "METHOD3"){
					res = method3Encode(pass);
				 }
				 else{
					 assert false : "unrecognised method";
				 }
			 }
		}
		
		return res;
	}
	//Newpass: just digited. Oldpass: on the database.
	public boolean decode (String newpass, String oldpass){
		return decodePhaseOne(newpass,oldpass);
	}
	
	private boolean decodePhaseOne(String newpass, String oldpass){
		String res =null;
		res += oldpass.charAt(0); // Copy the first character
		char j = oldpass.charAt(1); // Get the position of the character indicating the method used to encode the password
		int k =Character.getNumericValue(j);
		for(int i = 2 ; i < k ; i++) {  // Copy another section of the password string
		    char c = oldpass.charAt(i); 
		    res = res + c;
		}
		char meth = oldpass.charAt(k); //Get the method used to encode the password
		for(int i = k+1, n = oldpass.length() ; i < n ; i++) { //Copy the rest of the password
		    char c = oldpass.charAt(i);
		    res = res + c;
		}
		boolean res1 = false;
		switch(meth){ //Call the appropriate decoding method
		case 0 : res1 = method1Decode(res, newpass);
				break;
		case 1 : res1 = method2Decode(res, newpass);
				break;
		case 2 : res1 = method3Decode(res, newpass);
				break;
		default :  assert false : "unrecognised method";
		}
		
		return res1;
	}
	
	//Basic Caesar Cipher
	private String method1Encode(String pass){ 
		/*String res = null;
		for(int i = 0, n = pass.length() ; i < n ; i++) { 
		    char c = pass.charAt(i); 
		    c+=1;
		    res = res + c;
		}*/
		int j = RANDOM.nextInt(pass.length()-2)+2;  //Choose the position, at random, where will be indicated the encoding method
		String res = null;
		char b = pass.charAt(0); // Copy the first Character
		b+=1; //Caesar Cipher(+1)
		res += b; 
		res += j;// Insert where to look for the encoding method
		for(int i = 1 ; i < j ; i++) { //Caesar Cipher(+1)
		    char c = pass.charAt(i); 
		    c+=1;
		    res = res + c;
		}
		res += 0; //Signal that it has been encoded by this method
		for(int i = j, n = pass.length() ; i < n ; i++) { //Caesar Cipher(+1)
		    char c = pass.charAt(i); 
		    c+=1;
		    res = res + c;
		}
		
		return res;
	}
	//Encrypted with SHA-1 algorithm.
	private String method2Encode(String pass){
		String res = null;
		  res = hashString(pass);
		  int j = RANDOM.nextInt(res.length()-2)+2;  //To find the hint
		String res1 = null;
		res1 += res.charAt(0);
		res1 +=  j;
		for(int i = 1 ; i < j ; i++) { 
		    char c = res.charAt(i);
		    res1 = res1 + c;
		}
		res1 += 1; //Signal that it has been encoded by this method
		for(int i = j, n = res.length() ; i < n ; i++) { 
		    char c = res.charAt(i);
		    res1 = res1 + c;
		}
		
		return res1;

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
	
	private String method3Encode(String pass){
		
		return null;
	}
	
	private boolean method1Decode (String oldpass, String newpass){
		/*String res = null;
		for(int i = 0, n = oldpass.length() ; i < n ; i++) { // Caesar Cipher(-1)
		    char c = oldpass.charAt(i); 
		    c -= 1;
		    res = res + c;
		}
		
		return res.equals(newpass); //Check if the two password match
		*/
		String pass = null;
		pass = method1Encode(newpass);
		String res =null;
		res += pass.charAt(0); // Copy the first character
		char j = pass.charAt(1); // Get the position of the character indicating the method used to encode the password
		int k =Character.getNumericValue(j);
		for(int i = 2 ; i < k ; i++) {  // Copy another section of the password string
		    char c = pass.charAt(i); 
		    res = res + c;
		}
		for(int i = k+1, n = pass.length() ; i < n ; i++) { //Copy the rest of the password
		    char c = pass.charAt(i);
		    res = res + c;
		}
		return pass.equals(oldpass); //Check if the two password match
	}
	
	private boolean method2Decode (String oldpass, String newpass){
		/*
		 * String res = null;
		 * res = method2Encode(newpass)
		 * return res.equals(oldpass);
		 */
		String pass = null;
		pass = method2Encode(newpass);
		String res =null;
		res += pass.charAt(0); // Copy the first character
		char j = pass.charAt(1); // Get the position of the character indicating the method used to encode the password
		int k =Character.getNumericValue(j);
		for(int i = 2 ; i < k ; i++) {  // Copy another section of the password string
		    char c = pass.charAt(i); 
		    res = res + c;
		}
		for(int i = k+1, n = pass.length() ; i < n ; i++) { //Copy the rest of the password
		    char c = pass.charAt(i);
		    res = res + c;
		}
		return pass.equals(oldpass); //Check if the two password match
	}
	
	private boolean method3Decode (String oldpass, String newpass){
		//return res.equals(newpass);
		return false;
	}
	

}
