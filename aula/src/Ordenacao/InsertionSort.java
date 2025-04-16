package Ordenacao;

public class InsertionSort {
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
    public void insertionSortMetodo(){
        for(int j = 1; j<list.length; j++){
            for(int i = j-1; i>=0; i--){
                if(list[i]>list[i+1]){
                    troca(i, i+1);
                } else break;
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        System.out.println("Antes: ");
        sort.imprimir();
        sort.insertionSortMetodo();
        System.out.println("Depois: ");
        sort.imprimir();
    }
}
