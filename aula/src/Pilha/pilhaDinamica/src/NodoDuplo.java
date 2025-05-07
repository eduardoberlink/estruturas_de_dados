package Pilha.pilhaDinamica.src;

/**
 * NodoDuplo essa classe serve para ajudar a funcionar a pilha de uma forma
 * dinamica.
 * 
 * @author Santos, E. M. B.
 * @version 1.0
 * @since 2025-05-
 */

public class NodoDuplo<T> {
    private NodoDuplo<T> anterior;
    private T dado;
    private NodoDuplo<T> proximo;

    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }
}
