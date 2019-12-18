package com.example.alg.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsUnique {

	
	public static boolean isUniqueChars(String str) {
	    int checker = 0;
	    for (int i = 0; i < str.length(); ++i) {
	        int val = str.charAt(i) - 'a';
	        //System.out.println("1 << val: " + (1 << val));
	        if ((checker & (1 << val)) > 0) return false;
	        checker |= (1 << val);
	    }
	    return true;
	}
	
	
	public static boolean hasUniqueChars(String cad) {
		Map<Character, Character> unique = new HashMap<>();
		
		char[] charCad = cad.toCharArray();
		for(char car : charCad) {
			if(!unique.containsKey(car)) {
				unique.put(car, car);
			} else {
				return false;
			}
		}
		
		return true;		
	}
	
	public static void main(String[] args) {
		
		List<String> testStrings = Arrays.asList("test", "model", "book", "random", "unique" , "abcedf", "aaaabbb");
		
		/*
		testStrings.forEach(item -> {
			System.out.println(String.format("%s is unique: %b", item, hasUniqueChars(item)));
		});
		System.out.println();
		*/
		testStrings.forEach(item -> {
			System.out.println(String.format("%s is unique: %b", item, isUniqueChars(item)));
		});
		
	}
}
