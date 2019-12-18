package com.example.ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class HashTableImpl {

	// LinkedList<LinkedList<String>>[] hashTable = new LinkedList[10];
	LinkedList<Node>[] hashTable = new LinkedList[10];

	public void put(String key, String value) {
		int index = key.hashCode() % hashTable.length;
		System.out.println("Index: " + index);
		if (index < hashTable.length) {
			if (hashTable[index] == null) {
				hashTable[index] = new LinkedList<>();
			}
			hashTable[index].add(new Node(key, value));
		}
	}

	public String get(String key) {
		int index = key.hashCode() % hashTable.length;
		if (index < hashTable.length) {
			/*
			 * return hashTable[index].forEach(node -> { if(key.contentEquals(node.key)) {
			 * return node.value; } });
			 */
			Optional<Node> nodeOpt = hashTable[index].stream().filter(item -> key.equals(item.key)).findFirst();
			if (nodeOpt.isPresent()) {
				return nodeOpt.get().value;
			}

		}
		return null;
	}

	public static void main(String[] args) {

		Map<String, String> myMap = new HashMap<>();
		myMap.put("1", "hi");
		myMap.put("2", "bye");
		myMap.put("1", "test");
		
		myMap.put("AaBB", "test1");
		myMap.put("BBAa", "test2");

		System.out.println(myMap.get("2"));
		System.out.println(myMap.get("1"));
		
		System.out.println(myMap.get("AaBB"));
		System.out.println(myMap.get("BBAa"));
		
		System.out.println("AaBB: " + "AaBB".hashCode());
	    System.out.println("BBAa: " + "BBAa".hashCode());

		HashTableImpl hashTable = new HashTableImpl();

		hashTable.put("1", "hi");
		hashTable.put("2", "bye");
		
		hashTable.put("1", "test");

		System.out.println("hi".hashCode());

		System.out.println("Value of 2: " + hashTable.get("2"));
		System.out.println("Value of 1: " + hashTable.get("1"));
	}

	class Node {

		public Node() {

		}

		public Node(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		String key;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		String value;
	}
}
