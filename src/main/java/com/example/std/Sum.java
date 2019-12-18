package com.example.std;

import java.io.IOException;
import java.util.Scanner;

public class Sum {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int a, b, c;
		System.out.print("a:");
		a = in.nextInt();
		System.out.print("\nb:");
		b = in.nextInt();
		c = a + b;
		System.out.println(String.format("Result: %d", c));
		in.close();
	}
}
