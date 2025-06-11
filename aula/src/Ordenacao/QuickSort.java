package Ordenacao;

import java.util.Random;

public class QuickSort {
    private Object dados[];

    public QuickSort(Object[] dados) {
        this.dados = dados;
    }

    public void ordenar() {
        QuickSort(0, dados.length - 1);
    }

    private void QuickSort(int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = particao(esquerda, direita);

            QuickSort(esquerda, meio - 1);
            QuickSort(meio + 1, direita);
        }
    }

    private int particao(int esquerda, int direita) {
        int pivo = (Integer) dados[esquerda];
        int indicePivo = esquerda;

        for (int j = esquerda + 1; j <= direita; j++) {
            if ((Integer) dados[j] < pivo) {
                indicePivo++;
                trocar(indicePivo, j);
            }
        }
        trocar(esquerda, indicePivo);
        return indicePivo;
    }

    private void trocar(int a, int b) {
        Object aux = dados[a];
        dados[a] = dados[b];
        dados[b] = aux;
    }

    public String imprimir() {
        String resultado = "[";
        for (int i = 0; i < dados.length; i++) {
            if (i == dados.length - 1) {
                resultado += dados[i];
            } else {
                resultado += dados[i] + ",";
            }
        }
        return resultado + "]";
    }

    public static void main(String[] args) {
        Random gerador = new Random();
        Integer numeros[] = new Integer[20];
        // Preenchendo o vetor com números aleatórios
        for (int i = 0; i < numeros.length; i++) {
            // numeros aleatórios entre [10..200] incluindo-os
            numeros[i] = gerador.nextInt(190) + 10;
        }

        QuickSort sort = new QuickSort(numeros);
        System.out.println(sort.imprimir());
        sort.ordenar();
        System.out.println(sort.imprimir());
    }

}
