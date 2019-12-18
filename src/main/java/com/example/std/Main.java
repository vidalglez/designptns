package com.example.std;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public List<Integer> validateKeys(List<Integer> l, List<Integer> p) {
		List<Integer> results = new ArrayList<Integer>();
		for(Integer key : l) {
			Integer result = Collections.binarySearch(p, key);
			if(result < 0) {
				results.add(0);
			} else {
				results.add(result + 1);
			}
		}
		return results;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		if(m < 1 || m > 100000) {
			br.close();
			System.exit(0);
		}	
		
		List<Integer> p = new ArrayList<Integer>();
		String line1 = br.readLine();
		String[] items = line1.split(" ");
		//int  i = 0;
		for(String item : items) {
			p.add(Integer.parseInt(item));
			/*
			if(i != 0 && p.get(i) < p.get(i - 1)) {
				br.close();
				System.exit(0);
			}
			i++;
			*/
		}
		
		int n = Integer.parseInt(br.readLine());
		
		if(n < 1 || n > 100000) {
			br.close();
			System.exit(0);
		}	
		
		List<Integer> l = new ArrayList<Integer>();
		String line2 = br.readLine();
		items = line2.split(" ");

		for(String item : items) {
			l.add(Integer.parseInt(item));
		}

		br.close();
		
		Main mn = new Main();
		List<Integer> results = mn.validateKeys(l, p);

		for(int num : results) {
			System.out.print(String.format("%d ", num));
		}
		
	}
}
