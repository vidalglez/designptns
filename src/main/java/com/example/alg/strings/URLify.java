package com.example.alg.strings;

public class URLify {

	public static String replaceSpaces(String cad, int length) {
		if (length <= 0){
			return null;
		}
		char[] tmp = new char[length];
		for(int i = 0, j = 0; i < length; i++, j++) {
			if(cad.charAt(i) != ' ') {
				tmp[j] = cad.charAt(i);
			} else {
				tmp[j] = '%';
				char[] newtmp = new char[tmp.length + 2];
				int k = 0;
				for(; k <= j; k++) {
					newtmp[k] = tmp[k];
				}
				newtmp[k] = '2';
				newtmp[k + 1] = '0';
				j += 2;
				tmp = newtmp;
			}
		}
		return new String(tmp);
	}
	
	public static String getUrl(String cad, int length) {
		if (length <= 0){
			return null;
		}
		int countSpace = 0;
		for(int i = length; i > 0; i--) {
			if(cad.charAt(i -1) == ' ') {
				countSpace++;
			}
		}
		char[] converted = new char[length + countSpace * 2];
		int j = 0;
		for(int i = 0; i < length; i++) {
			if(cad.charAt(i) != ' ') {
				converted[j] = cad.charAt(i);
				j++;
			} else {
				converted[j] = '%';
				j++;
				converted[j] = '2';
				j++;
				converted[j] = '0';
				j++;
			}
		}
		return new String(converted);
	}
	
	public static void main(String[] args) {
		String url = replaceSpaces("Mr John Smith       ", 13);
		System.out.println(url);
		
		url = getUrl("Mr John Smith       ", 13);
		System.out.println(url);
	}
}
