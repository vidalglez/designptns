package com.example.designptns.builder;

public class InitialDemoBuilder {

	public static void main(String[] args) {
		String hello = "Hello";
		String p = "<p>\n\t" + hello + "\n</p>";
		System.out.println(p);
		
		StringBuilder b = new StringBuilder();
		b.append("<p>");
		b.append(hello);
		b.append("</p>\n");
		
		b.append("<ul>\n");
		String[] li = {"the", "coven"};
		for(String l : li) {
			b.append(String.format("\t<li>%s</li>\n", l));
		}
		b.append("</ul>\n");
		
		System.out.println(b);
		
	}
}
