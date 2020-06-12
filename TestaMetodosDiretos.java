
package gui;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TestaMetodosDiretos {

	public static void imprimirMatriz(double a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%8.2f ", a[i][j]);
			}
			System.out.println();
		}
	}
	public static void imprimirMatrizT(double a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%8.2f ", a[j][i]);
			}
			System.out.println();
		}
	}
	
	
	public static void imprimirVetor(double b[]) {

		for (int i = 0; i < b.length; i++) {

			System.out.printf("%8.5f ", b[i]);

			System.out.println();
		}
	}
	
	

	public static void imprimirResultados(double x[]) {
		System.out.println("Inc�gnitas:" + "\r\n");
		for (int i = 0; i < x.length; ++i) {

			System.out.println("x[" + i + "] = " + x[i]);

		}
		System.out.println();
	}
	public static void imprimirResultadosFS(double x[]) {
		System.out.println("Inc�gnitas:" + "\r\n");
		System.out.printf("{(" );
		for (int i = 0; i < x.length; ++i) {

			System.out.printf(", " + x[i]);

		}
		System.out.printf(")}" );
		System.out.println();
	}

	public static void main(String args[]) {

		

		// declara��o da matriz, lembrando que para utilizar o metodo cholesky a matriz precisa ser positiva e simetrica
		double a[][] = {
				{3,2,4},
				{1,1,2},
				{4,3,2}

		};
		// vetor para armazenar o resultado das icognitas dos xs  
		double b[] = { 1.0, 2.0, 3.0};

		int escolha = 0;
		while (escolha != 3) {
			System.out.println(" ************************ ");
			System.out.println("Escolha uma das fun��es abaixo:");
			System.out.println("Digite 1 para Fatora��o LU");
			System.out.println("Digite 2 para Fatora��o de Cholesky");
			System.out.println("Digite Enter para sair");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				escolha = Integer.parseInt(reader.readLine());
				
								if (escolha == 1) {
					System.out.println("Fatora��o LU");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					imprimirMatriz(a);
					System.out.println();
					System.out.println("Conjunto " + "\r\n");
					imprimirVetor(b);
					
					System.out.println();
					LU lu = new LU();
					double[] X = lu.resolve(a, b);
					imprimirResultados(X);
					imprimirResultadosFS(X);
					System.out.println();
					System.out.println();

				}
				if (escolha == 2) {
					System.out.println("Fatora��o de Cholesky");
					System.out.println();
					System.out.println("Matriz A" + "\r\n");
					 /*chama fun��o que imprme a matriz  original */
					imprimirMatriz(a);
					System.out.println();
					Cholesky cholesky = new Cholesky();
					double[][] G = cholesky.resolve(a);
					System.out.println("Matriz G " + "\r\n");
					imprimirMatriz(G);
					System.out.println("Matriz G^T " + "\r\n");
					//imprime a transposta
					imprimirMatrizT(G);
					
					/* fazendo a resolu��o do sistema linear*/
					
					System.out.println("Resolu��o do sistema : \n (metodo escolhido: Gaus Jorda) ");
					System.out.println();
					System.out.println("Conjunto Solu��o" + "\r\n");
					imprimirVetor(b);
					System.out.println();
					GaussJordan gaussJordan = new GaussJordan();
					double[] X = gaussJordan.resolve(G, b);
					imprimirResultados(X);
					System.out.println();
					System.out.println();
					
					
					/*fim resolu��o sistema linear*/
					
					System.out.println();
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Voce n�o digitou um n�mero");
				System.out.println("Saindo do Programa");
				return;
			}

		}

	}
}
