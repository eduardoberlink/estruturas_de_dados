package heapEstatico.arvoreBinariaHeapMaximo.src;

/**
 * Interface que define as operações básicas de uma estrutura de dados heap.
 * Um heap é uma árvore binária especial que satisfaz a propriedade de heap.
 * 
 * @author Eduardo Miranda Berlink Santos
 * @version 1.0
 * @since 2025-06-09
 */
public interface Amontoavel<T> {

    void inserir(T dado); // C

    T extrair(); // D

    T obterRaiz(); // R
    // metodos auxiliares:

    String imprimir();

    boolean estaVazia();

    boolean estaCheia();
}
