package Ordenacao;

public class BubbleSort {
    public int[] list = { 1, 6, 8, 3, 4, 2, 9, 5, 0 };

    public void troca(int indice1, int indice2) {
        int aux = list[indice1];
        list[indice1] = list[indice2];
        list[indice2] = aux;
    }

    public void imprimir() {
        for (int dado : list) {
            System.out.println(dado + " ");
        }
        System.out.println(" ");
    }

    public void bubbleSortMetodo() {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < (list.length - 1) - i; j++) {
                if (list[j] > list[j + 1]) {
                    troca(j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        System.out.println("Antes: ");
        sort.imprimir();
        sort.bubbleSortMetodo();
        System.out.println("Depois: ");
        sort.imprimir();
    }

}
