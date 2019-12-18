package com.example.coursera;

public class QuickUnionPathCompression {
	
	int id[];
	int sz[];
	
	public QuickUnionPathCompression(int n) {
		id = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public boolean connected(int p, int q) {
		return root(q) == root(p) ;
	}
	
	public int root(int i) {
		while(id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		if(i == j) {
			return;
		}
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}		
	}
	
	public void print() {
		System.out.print("[ ");
		for(int i : id) {
			System.out.print(i + " ");
		}
		System.out.print(" ]");
		
		System.out.print("[ ");
		for(int i : sz) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}
	
	public static void main(String[] args) {
		QuickUnionPathCompression qu = new QuickUnionPathCompression(10);
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
