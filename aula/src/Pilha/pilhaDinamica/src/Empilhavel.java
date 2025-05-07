package Pilha.pilhaDinamica.src;

/**
 * Esta interface indica as operações que uma classe deseja
 * ter o comportamento de ser empilhavel precisa.
 *
 * @author Santos, E. M. B.
 * @version 1.1
 * @since 2025-05-01
 *
 */

public interface Empilhavel<T> {
    void empilhar(T dado);

    T desempilhar();

    T espiar();

    void atualizar(T dado);

    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}
