import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private double[] results;
	private int trials;
	private double mean, stddev, confidenceLo, confidenceHi;

	public PercolationStats(int n, int trials) {
		this.trials = trials;
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException();
		}
		results = new double[trials];
		for (int i = 0; i < trials; i++) {
			Percolation p = new Percolation(n);
			double threshold = (double) p.numberOfOpenSites() / (double) (n * n);
			results[i] = threshold;
		}
		this.mean = StdStats.mean(results);
		this.stddev = StdStats.stddev(results);
		double partCalc = this.mean - (1.96 * this.stddev / Math.sqrt(this.trials));
		confidenceHi = this.mean + partCalc;
		confidenceLo = this.mean - partCalc;
	}

	public double mean() {
		return this.mean;
	}

	public double stddev() {
		return this.stddev;
	}

	public double confidenceLo() {
		return this.confidenceLo;
	}

	public double confidenceHi() {
		return this.confidenceHi;
	}

	public static void main(String[] args) {
		int n = Integer.valueOf(args[0]);
		int trials = Integer.valueOf(args[1]);

		PercolationStats ps = new PercolationStats(n, trials);
		System.out.println(String.format("mean                    = %.16f", ps.mean()));
		System.out.println(String.format("stddev                  = %.16f", ps.stddev()));
		System.out.println(
				String.format("95%% confidence interval = [%.16f, %.16f]", ps.confidenceLo(), ps.confidenceHi()));

	}
}
