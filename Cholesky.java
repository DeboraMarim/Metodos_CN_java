
package gui;

public class Cholesky {

	private int m;
	private double[][] g;

	public double[][] resolve(double[][] a) {
		m = a.length;
		g = new double[m][m]; // inicializa com 0

		// Mesmo processo que a fatoracao LU com um passo a mais G.Gt
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < (i + 1); k++) {
				double sum = 0;
				for (int j = 0; j < k; j++) {
					sum += g[i][j] * g[k][j];
				}
				g[i][k] = (i == k) ? Math.sqrt(a[i][i] - sum)
						: (1.0 / g[k][k] * (a[i][k] - sum));
			}
		}
		return g;
	}

}
