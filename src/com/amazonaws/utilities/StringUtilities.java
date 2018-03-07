package com.amazonaws.utilities;

public class StringUtilities {
	
	public static void main(String[] args) {}

	
	// Get the number out of String
	public static String exstractNumberFromString(String targetString) {
		String onlyNumber = "";
		for(int i = 0; i < targetString.length(); i++) {
			char eachChar = targetString.charAt(i);
			if (Character.isDigit(eachChar)) {
				onlyNumber += eachChar;
			}
		}
		return onlyNumber;
	}

}
