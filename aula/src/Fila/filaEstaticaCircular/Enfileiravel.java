package Fila.filaEstaticaCircular;
//Fila (Queue)

//Fila circular (Cycle Queue)
//Fila com Dupla Terminação (DeQueue)

public interface Enfileiravel {

    void enfileirar(Object dado); // C enqueue

    Object frente(); // R front

    void updateInicio(Object dado); // U update

    void updateFim(Object dado); // U update

    Object desenfileirar(); // D dequeue
                            // S sort

    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}
