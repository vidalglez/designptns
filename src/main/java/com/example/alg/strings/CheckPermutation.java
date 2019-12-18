package com.example.alg.strings;

import java.util.Arrays;

public class CheckPermutation {

	public static boolean isPermutation(String cad1, String cad2) {
		
		if (cad1.length() != cad2.length())
			return false;
		if(cad1.contentEquals(cad2)) {
			return false;
		}
		char[] cadSort1 = cad1.toCharArray();
		Arrays.sort(cadSort1);
		char[] cadSort2 = cad2.toCharArray();
		Arrays.sort(cadSort2);

		for (int i = 0; i < cadSort1.length; i++) {
			if (cadSort1[i] != cadSort2[i]) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPermutation("hola", "halo"));
		System.out.println(isPermutation("random", "mandor"));
		System.out.println(isPermutation("test", "test1"));
		System.out.println(isPermutation("hola", "hola"));
		
		
	}
}
