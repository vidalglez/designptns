package com.example.std;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class AliciaTest {

	Alicia a;

	@Before
	public void setup() {
		a = new Alicia();
	}

	@Test
	public void testSuccess() {
		int[] l = new int[] { 2, 5, 1, 8 };
		int[] p = new int[] { 1, 3, 4, 5, 9 };

		int[] res = new int[] { 0, 4, 1, 0 };
		//a.validateKeys(l, p);
		assertArrayEquals(res, l);
	}
	
	@Test
	public void testNotFound() {
		int[] l = new int[] { 2, 5, 1, 8 };
		int[] p = new int[] { 3, 4, 6, 9 , 11};

		int[] res = new int[] { 0, 0, 0, 0 };
		//a.validateKeys(l, p);
		assertArrayEquals(res, l);
	}
	
	@Test
	public void testAllFound() {
		int[] l = new int[] { 4, 6, 11, 16 };
		int[] p = new int[] { 3, 4, 6, 9 , 11, 15, 16};

		int[] res = new int[] { 2, 3, 5, 7 };
		//a.validateKeys(l, p);
		assertArrayEquals(res, l);
	}


}
