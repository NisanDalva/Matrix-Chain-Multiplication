
public class test {

	public static void main(String[] args) {
		int p[] = {5, 3, 20, 2, 100, 4};
		int n = p.length;

		int m[][] = new int[n][n];
		int s[][] = new int[n][n];


		MatrixChainOrder(p, n, m, s);
		print(m, "m");
		print(s, "s");

		System.out.println("Result:");
		snapshot(s, 1, n - 1);
		System.out.println("\nMinimum number of multiplications is " + m[1][n-1]);
	}

	public static void snapshot(int s[][], int i, int j) {
		if (i == j)
			System.out.print("A" + (i-1) + " ");
		else {
			System.out.print("( ");
			snapshot(s, i, s[i][j]);
			snapshot(s, s[i][j] + 1, j);
			System.out.print(") ");
		}
	}
	public static void MatrixChainOrder(int p[], int n, int m[][], int s[][]) {
		for(int i = 0; i < n; i++)
			m[i][i] = 0;

		for (int L = 2; L < n; L++)
			for (int i = 1; i < n - L + 1; i++) {
				int j = i + L - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int q = m[i][k] + m[k + 1][j] + p[i - 1]*p[k]*p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
	}


	public static void print(int mat[][], String name) {
		System.out.println(name + ":\n");

		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				if(i > j)
					System.out.print("\t ");
				else
					System.out.print(mat[i][j] + "\t");

			}
			System.out.println("\n");
		}
	}

}
