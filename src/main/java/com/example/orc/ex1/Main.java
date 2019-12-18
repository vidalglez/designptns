package com.example.orc.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cad1 = br.readLine();
		String cad2 = br.readLine();
		String cad3 = br.readLine();
		/*
		String cad1 = "anitalava";
		String cad2 = "latina";
		String cad3 = "anitalavalatina";
		*/
		/*
		String cad1 = "biiegon";
		String cad2 = "adios";
		String cad3 = "adbiieiosgon";
		*/
		/*
		String cad1 = "abc";
		String cad2 = "xyz";
		String cad3 = "axybcz";
		*/
		/*
		String cad1 = "abc";
		String cad2 = "xyz";
		String cad3 = "abxzcy";
		*/
		
		br.close();

		
		int j = 0, k = 0;
		for(int i = 0; i < cad3.length(); i++) {
			boolean char1 = false; 
			boolean char2 = false; 
			if(j < cad1.length()) {
				if(cad1.charAt(j) == cad3.charAt(i)) {
					j++;
					char1 = true;
					//i++;
				} else {
					if(k < cad2.length()) {
						if(cad2.charAt(k) == cad3.charAt(i)) {
							k++;
							char2 = true;
							//i++;
						}
					}
				}
			//}
			} else {
				if(k < cad2.length()) {
					if(cad2.charAt(k) == cad3.charAt(i)) {
						k++;
						char2 = true;
						//i++;
					} 
				} else {
					if(j < cad1.length()) {
						if(cad1.charAt(j) == cad3.charAt(i)) {
							j++;
							char1 = true;
							//i++;
						}
					}
				}
			}
			
			if(!char1 && !char2) {

				System.out.println("INVALID MERGE");
				System.exit(0);
			}
			
		}
		System.out.println("VALID MERGE");
	}
}
