package Pilha.pilhaEstatica.PilhaComFila;

public interface Empilhavel {
    void empilhar(Object dado); // c

    Object espiar(); // r

    void atualizar(Object dado); // u

    Object desempilhar(); // d

    // metodos auxiliares
    boolean estaCheia();

    boolean estaVazia();

    String imprimir();

}
