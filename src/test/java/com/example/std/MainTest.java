package com.example.std;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

	Main a;
	
	@Before
	public void setup() {
		a = new Main();
	}

	@Test
	public void testSuccess() {
		List<Integer> l = Arrays.asList(new Integer[] { 2, 5, 1, 8 });
		List<Integer> p = Arrays.asList(new Integer[] { 1, 3, 4, 5, 9 });

		List<Integer> expected = Arrays.asList(new Integer[] { 0, 4, 1, 0 });
		
		List<Integer> actual = a.validateKeys(l, p);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNotFound() {
		List<Integer> l = Arrays.asList(new Integer[] { 2, 5, 1, 8 });
		List<Integer> p = Arrays.asList(new Integer[] { 3, 4, 6, 9 , 11});

		List<Integer> expected = Arrays.asList(new Integer[] { 0, 0, 0, 0 });
		List<Integer> actual = a.validateKeys(l, p);
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testAllFound() {
		List<Integer> l = Arrays.asList(new Integer[] { 4, 6, 11, 16 });
		List<Integer> p = Arrays.asList(new Integer[] { 3, 4, 6, 9 , 11, 15, 16});

		List<Integer> expected = Arrays.asList(new Integer[] { 2, 3, 5, 7 });

		List<Integer> actual = a.validateKeys(l, p);
		assertEquals(expected, actual);
	}
}
