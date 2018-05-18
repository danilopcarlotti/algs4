import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private final WeightedQuickUnionUF wqu;
	private final int[][] matrix;
	private final int size;
	public Percolation(int n) {
		if (n < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		size = n;
		matrix = new int[n][n];
		wqu = new WeightedQuickUnionUF((n*n)+2);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			wqu.union(0, i+1);
			wqu.union((n*n)+1, (n*n)-i);
		}
	}
	public boolean isOpen(int row, int col) {
		if (row < 0 || col < 0 || row > size || col > size) {
			throw new java.lang.IllegalArgumentException();
		}
		return matrix[(row-1)][(col-1)] == 1;
	}
	public void open(int row, int col) {
		if (row < 0 || col < 0 || row > size || col > size) {
			throw new java.lang.IllegalArgumentException();
		}
		matrix[row-1][col-1] = 1;
		if ((row-2 >= 0) && isOpen(row-1,col)) {
			wqu.union((size*(row-1))+col, (size*(row-2))+col);
		}
		if ((row+1 <= size) && isOpen(row+1,col)) {
			wqu.union((size*(row-1))+col, (size*(row+1))+col);
		}
		if ((col-2 >= 0) && isOpen(row,col-1)) {
			wqu.union((size*(row-1))+col, (size*(row-1))+col-1);
		}
		if ((col+1 <= size) && isOpen(row,col+1)) {
			wqu.union((size*(row-1))+col, (size*(row-1))+col+1);
		}
	}
	public boolean isFull(int row, int col) {
		if (row < 0 || col < 0 || row > size || col > size) {
			throw new java.lang.IllegalArgumentException();
		}
		if (isOpen(row, col)) return wqu.connected(0, (size*(row-1))+col);
		else return false;
	}
	public int numberOfOpenSites() {
		int counter = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] == 1) counter += 1;
			}
		}
		return counter;
	}
	public boolean percolates(){
		return wqu.connected(0, size*size+1);
	}
	public static void main(String[] args) {
//		Percolation p = new Percolation(8);
//		System.out.println(p.isFull(1,1));
//		System.out.println(p.isOpen(1,1));
//		p.open(1, 1);
//		System.out.println(p.isFull(1,1));
   }
}