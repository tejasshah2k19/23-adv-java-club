package com.util;

public class Validation {

	// null or whitespace 0 length
	public static boolean isBlank(String data) {
		if (data == null || data.trim().length() == 0) {
			return true;
		} else {
			return false;
		}

		// return data == null || data.trim().length() == 0 ;

	}

	public static boolean isAlpha(String data) {
		String alphaReg = "[a-zA-Z]+"; // + -> 1 or many
		return data.matches(alphaReg);
	}

	public static void main(String[] args) {
		System.out.println(Validation.isBlank("   "));
		System.out.println(Validation.isBlank("ram"));

		System.out.println(Validation.isAlpha("ram"));
		System.out.println(Validation.isAlpha("ram1"));
		System.out.println(Validation.isAlpha("1ram"));
		System.out.println(Validation.isAlpha("ra1m"));
		System.out.println(Validation.isAlpha("ram ravan"));
		
	}
}
