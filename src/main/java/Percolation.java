import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int[][] percolations;
	private int[][] matrix;
	private WeightedQuickUnionUF qf;
	private int numItems;
	private int openSites = 0;
	private boolean percolates = false;

	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		percolations = new int[n][n];
		matrix = new int[n][n];
		numItems = n * n + 2;
		qf = new WeightedQuickUnionUF(numItems);
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				percolations[i][j] = 1;
				matrix[i][j] = count;
				count++;
			}
		}
		this.setVirtualTopSite(n, 0);
		this.setVirtualBottomSite(n, numItems - 1);
		this.execute();
	}

	private void setVirtualTopSite(int n, int root) {

		for (int i = 1; i <= n; i++) {
			qf.union(root, i + root);
		}
		// System.out.println("Done");
	}

	private void setVirtualBottomSite(int n, int root) {
		for (int i = 1; i <= n; i++) {
			qf.union(root, root - i - 1);
		}
		// System.out.println("Done");
	}

	public void open(int row, int col) {
		if (row < 0 || col < 0) {
			throw new IllegalArgumentException();
		}
		percolations[row][col] = 0;
		openSites++;
		if (isValidUnion(row - 1, col) && isOpen(row - 1, col)) {
			qf.union(matrix[row][col], matrix[row - 1][col]);
		}
		if (isValidUnion(row + 1, col) && isOpen(row + 1, col)) {
			qf.union(matrix[row][col], matrix[row + 1][col]);
		}
		if (isValidUnion(row, col - 1) && isOpen(row, col - 1)) {
			qf.union(matrix[row][col], matrix[row][col - 1]);
		}
		if (isValidUnion(row, col + 1) && isOpen(row, col + 1)) {
			qf.union(matrix[row][col], matrix[row][col + 1]);
		}
	}

	public boolean isOpen(int row, int col) {
		if (row < 0 || col < 0) {
			throw new IllegalArgumentException();
		}
		return percolations[row][col] == 0;
	}

	private boolean isValidUnion(int row, int col) {
		if (row - 1 < 0 || col - 1 < 0 || row >= percolations.length || col >= percolations.length) {
			return false;
		}
		return true;
	}

	public boolean isFull(int row, int col) {
		if (row < 0 || col < 0) {
			throw new IllegalArgumentException();
		}
		return percolations[row][col] == 1;
	}

	public int numberOfOpenSites() {
		return openSites;
	}

	private void execute() {
		int p = 0, q = numItems - 1;
		while (!connected(p, q)) {
			int i = StdRandom.uniform(percolations.length);
			int j = StdRandom.uniform(percolations.length);
			if (isFull(i, j)) {
				open(i, j);
			}
		}
		percolates = true;
	}

	public boolean percolates() {
		return percolates;
	}

	private boolean connected(int p, int q) {
		return qf.find(p) == qf.find(q);
	}

	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		Percolation p = new Percolation(n);
		System.out.println(String.format("Open sites to percolate: %d, *p: %.10f", p.numberOfOpenSites(),
				(double) p.numberOfOpenSites() / (double) (n * n)));
	}
}
