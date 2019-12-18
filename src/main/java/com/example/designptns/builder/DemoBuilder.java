package com.example.designptns.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoBuilder {

	class HtmlElement {

		private String name, text;
		private List<HtmlElement> elements = new ArrayList<>();
		private final int identSize = 2;
		private final String newLine = System.lineSeparator();

		public HtmlElement() {

		}

		public HtmlElement(String name, String text) {
			super();
			this.name = name;
			this.text = text;
		}

		private String toStringImpl(int ident) {
			StringBuilder sb = new StringBuilder();
			String i = String.join("", Collections.nCopies(ident * identSize, " "));
			sb.append(String.format("%s<%s>%s", i, name, newLine));
			if (text != null && !text.isEmpty()) {
				sb.append(String.join("", Collections.nCopies(identSize * (ident + 1), " "))).append(text)
						.append(newLine);
			}

			for (HtmlElement e : elements) {
				sb.append(e.toStringImpl(ident + 1));
			}

			sb.append(String.format("%s</%s>%s", i, name, newLine));
			return sb.toString();
		}

		@Override
		public String toString() {
			return this.toStringImpl(0);
		}

	}

	class HtmlBuilder {

		private String rootName;
		private HtmlElement root = new HtmlElement();

		public HtmlBuilder(String rootName) {
			this.rootName = rootName;
			this.root.name = rootName;

		}

		public HtmlBuilder addChild(String childName, String childText) {
			HtmlElement e = new HtmlElement(childName, childText);
			root.elements.add(e);
			return this;
		}

		public void clear() {
			root = new HtmlElement();
			root.name = rootName;
		}

		@Override
		public String toString() {
			return root.toString();
		}
	}

	public static void main(String[] args) {
		HtmlBuilder builder = new DemoBuilder().new HtmlBuilder("ul");
		/*
		builder.addChild("li", "hello");
		builder.addChild("li", "hello");
		*/
		//This is known as fluent interface
		builder
			.addChild("li", "hello")
			.addChild("li", "hello");
		System.out.println(builder);

	}
}
