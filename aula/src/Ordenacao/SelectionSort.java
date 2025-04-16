package Ordenacao;

public class SelectionSort {
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

    public void selectionSortMetodo() {
        for (int j = 0; j < list.length; j++) {
            int menor = j;
            for (int i = 1 + j; i < list.length; i++) {
                if (list[menor] > list[i]) {
                    menor = i;
                }
            }
            troca(j, menor);
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        System.out.println("Antes: ");
        sort.imprimir();
        sort.selectionSortMetodo();
        System.out.println("Depois: ");
        sort.imprimir();
    }
}
