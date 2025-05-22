package Fila.FilaEstaticA.FilaComPilha;

public interface Empilhavel {

    // metodos principais
    void empilhar(Object dado); // c

    Object espiar(); // r

    void atualizar(Object dado); // u

    Object desempilhar(); // d

    // metodos auxiliares
    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}
