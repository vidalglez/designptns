package com.example.std;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alicia {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		if(m < 1 || m > 100000) {
			br.close();
			System.exit(0);
		}	

		int[] p = new int[m];
		String line1 = br.readLine();
		String[] items = line1.split(" ");
		int  i = 0;
		for(String item : items) {
			p[i] = Integer.parseInt(item);
			/*if(i != 0 && p[i] < p[i - 1]) {
				br.close();
				System.exit(0);
			}*/
			i++;
		}
		Arrays.sort(p);
		
		int n = Integer.parseInt(br.readLine());
		
		if(n < 1 || n > 100000) {
			br.close();
			System.exit(0);
		}	
		
		int[] l = new int[n];
		String line2 = br.readLine();
		items = line2.split(" ");
		int j = 0;
		for(String item : items) {
			l[j] = Integer.parseInt(item);
			j++;
		}

		br.close();
		
		for (int k = 0; k < l.length; k++) {
			int searchResult = Arrays.binarySearch(p, l[k]) ;
			System.out.print(String.format("%d ", searchResult < 0 ? 0 : searchResult + 1));
		}
		
	}
}
