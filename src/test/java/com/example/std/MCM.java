package com.example.std;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MCM {
	
	public static void generateArray(int[] entries) {
		int max = 50;//1000000;
		int min = 1;
		int range = max - min + 1;
		for(int i = 0; i < entries.length; i++) {
			entries[i] = (int) (Math.random() * range) + min;
			//System.out.print();
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int numEntries = Integer.parseInt(br.readLine());
		int numEntries = 130000;
		
		if(numEntries < 2 || numEntries > 130000) {
			br.close();
			System.exit(0);
		}
		
		int[] entry = new int[numEntries];
		//int[] entry = new int[]{994098, 864475, 891204, 108321, 712644};
		generateArray(entry);
		System.out.println(Arrays.toString(entry));
		/*
		String entries = br.readLine();
		
		String[] items = entries.split(" ");
		
		if(items.length != numEntries) {
			br.close();
			System.exit(0);
		}
		
		for(int i = 0; i < entry.length; i++) {
			entry[i]  = Integer.parseInt(items[i]);
			if(entry[i] > 1000000) {
				System.exit(0);
			}
		}
		*/
		//int[] entry = new int[] {9, 12};
		
		
		System.out.println("Array initialization with random numbers completed....");
		//int[] entry = new int[] {9, 12};
		//int[] entry = new int[] {324, 16, 5, 7};
		
		//entry = new int[] {3, 6, 12};
		
		
		int initialMultplier = 2;
		int numberOfOnes = 0;
		long mcm = 1;
		System.out.println("Calculatin MCM .....");
		while(numberOfOnes < entry.length) {
			boolean wasMultiplied = false;
			
			for(int i = 0; i < entry.length; i++) {
				if(entry[i] != 1) {
					
					if(entry[i] % initialMultplier == 0 ) {
						wasMultiplied = true;
						entry[i] = entry[i] / initialMultplier;
						if(entry[i] == 1) {
							numberOfOnes++;
						}
					}
				}
			}
			
			if(!wasMultiplied) {
				initialMultplier++;
			} else {
				mcm *= initialMultplier;
			}
		}
		
		System.out.println(mcm);
		br.close();

	}
}
