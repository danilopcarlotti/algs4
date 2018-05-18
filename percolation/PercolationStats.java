import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
	
	private final double[] trials_data_treshold;
	private final int ntrials;
	private final static double CONFIDENCE_95 = 1.96;

   public PercolationStats(int n, int trials) {
   	ntrials = trials;
	   trials_data_treshold = new double[trials];
	   for (int i = 0; i < trials; i++) {
		   int blockx, blocky;
		   Percolation p = new Percolation(n);
		   while (p.percolates() == false){
			   blockx = StdRandom.uniform(1, n);
			   blocky = StdRandom.uniform(1, n);
			   p.open(blockx, blocky);
		   }
		   double x = p.numberOfOpenSites();
		   double size_n = n*n;
		   trials_data_treshold[i] = x/size_n;
		}
	}
	public double mean() {
		return StdStats.mean(trials_data_treshold);
	}
	public double stddev() {
		return StdStats.stddev(trials_data_treshold);
	}
	public double confidenceLo(){
		return (StdStats.mean(trials_data_treshold) - ((CONFIDENCE_95*StdStats.stddev(trials_data_treshold))/Math.sqrt(ntrials)));
	}
	public double confidenceHi(){
		return (StdStats.mean(trials_data_treshold) + ((CONFIDENCE_95*StdStats.stddev(trials_data_treshold))/Math.sqrt(ntrials)));
	}
	public static void main(String[] args) {
//		PercolationStats p = new PercolationStats(200,100);
//		System.out.println(p.mean());
	}
}