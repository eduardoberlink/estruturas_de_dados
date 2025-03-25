package Fila;

public interface DuplamenteEnfileiravel {

    void enfilerarInicio(Object dado);

    void enfilerarFim(Object dado);

    Object frente();

    Object tras();

    void atualizarInicio(Object dado);

    void atualizarFim(Object dado);

    Object desenfilerarInicio();

    Object desenfilerarFim();

    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}
