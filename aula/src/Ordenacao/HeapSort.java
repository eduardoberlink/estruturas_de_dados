package Ordenacao;

public class HeapSort {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) Math.floor(Math.random() * vetor.length);
        }
        System.out.println("Desordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        // Heap Sort
        int tamanho = vetor.length;
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            aplicarHeap(vetor, tamanho, i);
        }

        for (int j = tamanho - 1; j > 0; j--) {
            int aux = vetor[0];
            vetor[0] = vetor[j];
            vetor[j] = aux;

            aplicarHeap(vetor, j, 0);
        }
        System.out.println("\n\nOrdenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    private static void aplicarHeap(int[] vetor, int tamanho, int i) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < tamanho && vetor[esquerda] > vetor[raiz]) {
            raiz = esquerda;
        }
        if (direita < tamanho && vetor[direita] > vetor[raiz]) {
            raiz = direita;
        }
        if (raiz != i) {
            int aux = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz] = aux;

            aplicarHeap(vetor, tamanho, raiz);
        }

    }
}
