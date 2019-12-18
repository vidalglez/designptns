package com.example.orc.ex1;

public class ConvertToUpper {

	
	public String toUpper(String cad) {
		char[] cadChar = cad.toCharArray();
		StringBuilder conver = new StringBuilder();
		
		for(char c : cadChar) {
			if(c >= 97 && c <= 122 ) {
				c = (char)(c - 32);
			}	
			conver.append(c);
		}
		return conver.toString();
	}
	
	public static void main(String[] args) {
		ConvertToUpper conv = new ConvertToUpper();
		String cad1 = "Hello World!";
		System.out.println(String.format("Original cad: %s, upper case: %s", cad1, conv.toUpper(cad1)));
	}
}
