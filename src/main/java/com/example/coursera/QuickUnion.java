package com.example.coursera;

public class QuickUnion {
	
	int id[];
	
	public QuickUnion(int n) {
		id = new int[n];
		for(int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return (root(q) == root(p)) ? true : false;
	}
	
	public int root(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q) {
		p = root(p);
		q = root(q);
		id[p] = q;
	}
	
	public void print() {
		System.out.print("[ ");
		for(int i : id) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}
	
	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		qu.union(4, 3);
		qu.print();
		qu.union(3, 8);
		qu.print();
		qu.union(6, 5);
		qu.print();
		qu.union(9, 4);
		qu.print();
		qu.union(2, 1);
		qu.print();
		qu.union(5, 0);
		qu.print();
		qu.union(7, 2);
		qu.print();
		qu.union(6, 1);
		qu.print();
		qu.union(7, 3);
		qu.print();
		
	}

}
