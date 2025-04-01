package Fila.FilaDupla;

public interface DuplamenteEnfileiravel {

    void enfileirarInicio(Object dado);

    void enfileirarFim(Object dado);

    Object frente();

    Object tras();

    void atualizarInicio(Object dado);

    void atualizarFim(Object dado);

    Object desenfileirarInicio();

    Object desenfileirarFim();

    boolean estaCheia();

    boolean estaVazia();

    String imprimirTrasFrente();
    String imprimirFrenteTras();
}
