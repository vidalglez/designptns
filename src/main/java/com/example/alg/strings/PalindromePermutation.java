package com.example.alg.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	public static boolean isPermutationPalindrome(String cad) {
		cad = cad.toLowerCase();
		Map<Character, Integer> dict = new HashMap<>();

		for (int i = 0; i < cad.length(); i++) {
			if (cad.charAt(i) != ' ') {
				if (dict.containsKey(cad.charAt(i))) {
					dict.put(cad.charAt(i), dict.get(cad.charAt(i)) + 1);
				} else {
					dict.put(cad.charAt(i), 1);
				}
			}
		}

		int countOdd = 0;
		for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				countOdd++;
			}
			if (countOdd > 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String cad = "Tact Coa";
		System.out.println(String.format("is Permutation Palindrome: %s %b", cad, isPermutationPalindrome(cad)));
		cad = "somos";
		System.out.println(String.format("is Permutation Palindrome: %s %b", cad, isPermutationPalindrome(cad)));
		
		cad = "Tact Coa M";
		System.out.println(String.format("is Permutation Palindrome: %s %b", cad, isPermutationPalindrome(cad)));
	}

}
