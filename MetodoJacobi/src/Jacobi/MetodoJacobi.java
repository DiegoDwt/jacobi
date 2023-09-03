package Jacobi;

import java.util.Arrays;


class MetodoJacobi {
	
	    static final int MAX_ITERACOES = 1000;
	    static final double ALPHA = 0.0000000000000001;    // Ao diminiur o Alpha aumenta a precisão do sistema

	    public static void main(String[] args) {
	    	
	    	// Definição da matriz A e b do sistema linear
	        double[][] A = {
	            {-3, 2, -1},
	            { 0.5, 6, 2},
	            { -1, 2, -5},
	        };
	        double[] b = { 2, 1, 6};

	        int n = b.length;
	        double[] estimativaInicial = new double[n];
	        double[] estimativaAtualizada = new double[n];

	        // Inicialização das estimativas iniciais como zero
	        for (int i = 0; i < n; i++) {
	            estimativaInicial[i] = 0;
	        }

	        // Iterações do método de Jacobi
	        for (int iteration = 1; iteration <= MAX_ITERACOES; iteration++) {
	        	// Cálculo das estimativas atualizadas
	        	for (int i = 0; i < n; i++) {
	                double sum = b[i];
	                for (int j = 0; j < n; j++) {
	                    if (j != i) {
	                        sum -= A[i][j] * estimativaInicial[j];
	                    }
	                }
	                estimativaAtualizada[i] = sum / A[i][i];
	            }

	        	 // Cálculo da diferença máxima entre as estimativas atualizadas e as estimativas anteriores
	            double maxDifference = Math.abs(estimativaAtualizada[0] - estimativaInicial[0]);
	            for (int i = 1; i < n; i++) {
	                double difference = Math.abs(estimativaAtualizada[i] - estimativaInicial[i]);
	                if (difference > maxDifference) {
	                    maxDifference = difference;
	                }
	            }

	            // Verificação do critério de convergência
	            if (maxDifference < ALPHA) {
	                System.out.println("Converge após " + iteration + " iterações");
	                break;
	            }

	            // Atualização das estimativas iniciais para a próxima iteração
	            for (int i = 0; i < n; i++) {
	                estimativaInicial[i] = estimativaAtualizada[i];
	            }
	        }

	        // Impressão da solução final
	        System.out.println("Solução:");
	        for (int i = 0; i < n; i++) {
	            System.out.println(estimativaAtualizada[i]);
	        }
	    }
	   
 }
	
