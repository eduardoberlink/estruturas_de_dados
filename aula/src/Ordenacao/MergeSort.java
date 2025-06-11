package Ordenacao;

import java.util.Random;

public class MergeSort {

    private Object dados[];

    public MergeSort(Object[] dados) {
        this.dados = dados;

    }

    public void ordenar() {
        Object[] temp = new Object[dados.length];
        MergeSort(temp, 0, dados.length - 1);
    }

    private void MergeSort(Object[] temp, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            MergeSort(temp, esquerda, meio);
            MergeSort(temp, meio + 1, direita);

            intercalar(temp, esquerda, meio, direita);
        }
    }

    private void intercalar(Object[] temp, int esquerda, int meio, int direita) {
        for (int i = esquerda; i <= direita; i++) {
            temp[i] = dados[i];
        }

        int i = esquerda;
        int j = meio + 1;
        int k = esquerda;

        while (i <= meio && j <= direita) {
            if ((Integer) temp[i] <= (Integer) temp[j]) {
                dados[k] = temp[i];
                i++;
            } else {
                dados[k] = temp[j];
                j++;
            }
            k++;
        }

        // se a metade inicial não foi toda consumida, faz o append.
        while (i <= meio) {
            dados[k] = temp[i];
            i++;
            k++;
        }

        // se a metade final não foi toda consumida, faz o append.
        while (j <= direita) {
            dados[k] = temp[j];
            j++;
            k++;
        }
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

        MergeSort sort = new MergeSort(numeros);
        System.out.println(sort.imprimir());
        sort.ordenar();
        System.out.println(sort.imprimir());
    }

}
