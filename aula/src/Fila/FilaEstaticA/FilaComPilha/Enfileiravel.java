package Fila.FilaEstaticA.FilaComPilha;

public interface Enfileiravel {

    void enfileirar(Object dado); // c

    Object frente(); // r

    void atualizarInicio(Object dado);// u

    void atualizarFim(Object dado);

    Object desenfileirar();// d

    // metodos auxiliares
    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}
