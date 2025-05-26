package Fila.FilaDinamica.src;

/**
 * Interface que define as operações básicas de uma fila genérica.
 * Esta interface define os métodos que devem ser implementados
 * por qualquer classe que represente uma estrutura de dados do tipo fila.
 *
 * @param <T> o tipo dos elementos armazenados na fila
 * @author Santos, E. M. B.
 * @version 1.1
 * @since 2025-05-01
 */
public interface Enfileiravel<T> {

    void enfileirarInicio(T dado);

    void enfileirarFim(T dado);

    T frente();

    T tras();

    void atualizarInicio(T dado);

    void atualizarFim(T dado);

    T desenfileirarInicio();

    T desenfileirarFim();

    boolean estaCheia();

    boolean estaVazia();

    String imprimirDeTrasPraFrente();

    String imprimirDeFrentePraTras();

}
