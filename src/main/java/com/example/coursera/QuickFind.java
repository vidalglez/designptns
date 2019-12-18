package com.example.coursera;

public class QuickFind {
	
	class UF{
		
		int[] arrNums;
		
		public UF(int n) {
			arrNums = new int[n];
			for(int i = 0; i < n; i++) {
				arrNums[i] = i;
			}
		}
		
		public void union(int p, int q) {
			//arrNums[p] = arrNums[q];
			int arrNumsP = arrNums[p];
			int arrNumsQ = arrNums[q];
			for(int i = 0; i < arrNums.length; i++) {
				if(arrNums[i] == arrNumsP) {
					arrNums[i] = arrNumsQ;
				}
				/*
				if(arrNums[i] == p) {
					arrNums[i] = q;
				}
				*/
			}
			System.out.println(String.format("(%d, %d)", p, q));
		}
		
		public boolean connected(int p, int q) {
			if(arrNums[p] == arrNums[q]) {
				return true;
			}
			return false;
		}
		
		int find(int p) {
			return 0;
		}
		
		int count() {
			return 0;
		}
		
		public void print() {
			for(int i = 0; i < arrNums.length; i++) {
				System.out.print(arrNums[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int num = 10;
		
		UF uf = new QuickFind().new UF(num);
		uf.union(4, 3);
		uf.print();
		uf.union(3, 8);
		uf.print();
		uf.union(6, 5);
		uf.print();
		uf.union(9, 4);
		uf.print();
		uf.union(2, 1);
		uf.print();
		System.out.println(String.format("Connected: %b", uf.connected(0, 7)));
		System.out.println(String.format("Connected: %b", uf.connected(8, 9)));
		uf.union(5, 0);
		uf.print();
		uf.union(7, 2);
		uf.print();
		uf.union(6, 1);
		uf.print();
		uf.union(1, 0);
		System.out.println(String.format("Connected: %b", uf.connected(0, 7)));
		uf.print();
		
		/*
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int num = Integer.valueOf(br.readLine());
			UF uf = new UFMain().new UF(num);
			for(int i = 0; i < num; i++) {
				String[] pairs = br.readLine().split(" ");
				int p = Integer.valueOf(pairs[0]);
				int q = Integer.valueOf(pairs[1]);
				
				if(!uf.connected(p, q)) {
					uf.union(p, q);
					System.out.println(String.format("(%d, %d)", p, q));
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		*/
	}
}
