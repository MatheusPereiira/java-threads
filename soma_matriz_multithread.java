import java.util.concurrent.*;

public class soma_matriz_multithread {
    public static void main(String[] args) throws Exception {
        int linhas = 1000;
        int colunas = 1000;
        int[][] matriz = new int[linhas][colunas];
        
        // Preencher matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = 1; // Para facilitar, todos são 1. Soma esperada: 1000000
            }
        }

        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long somaTotal = 0;

        int linhasPorThread = linhas / numThreads;
        Future<Long>[] resultados = new Future[numThreads];

        for (int t = 0; t < numThreads; t++) {
            final int inicio = t * linhasPorThread;
            final int fim = (t == numThreads - 1) ? linhas : inicio + linhasPorThread;

            resultados[t] = executor.submit(() -> {
                long somaParcial = 0;
                for (int i = inicio; i < fim; i++) {
                    for (int j = 0; j < colunas; j++) {
                        somaParcial += matriz[i][j];
                    }
                }
                return somaParcial;
            });
        }

        for (int t = 0; t < numThreads; t++) {
            somaTotal += resultados[t].get();
        }

        executor.shutdown();
        System.out.println("Soma total da matriz: " + somaTotal);
    }
}
