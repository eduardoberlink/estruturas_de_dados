package Pilha.pilhaDinamica.src;

import java.util.NoSuchElementException;

/**
 * É uma classe que implementa uma pilha, que usa o
 * LIFO(last in first out)
 *
 * @author Santos, E. M. B.
 * @version 1.1
 * @since 2025-05-01
 *
 */

public class PilhaDinamicaGenerica<T> implements Empilhavel<T> {

    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor vazio
     */
    public PilhaDinamicaGenerica() {
        this(10);
    }

    /**
     * Construtor vazio
     * 
     * @param tamanho, refere-se ao tamanho
     *                 máx que a ED pode ter.
     */
    public PilhaDinamicaGenerica(int tamanho) {
        ponteiroTopo = null;
        quantidade = 0;
        this.tamanho = tamanho;
    }

    /**
     * O metodo empilha os dados da pilha
     * 
     * @return dado que foi empilhado
     * @param o, dado que é empilhado na pilha
     * @throws NoSuchElementException se a pilha estiver cheia
     */
    @Override
    public void empilhar(T o) {
        if (estaCheia()) {
            throw new NoSuchElementException("Pilha cheia!");
        }
        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(o);
        ponteiroTopo.setProximo(novoNodo);
        novoNodo.setAnterior(ponteiroTopo);
        ponteiroTopo = novoNodo;
        quantidade++;

    }

    /**
     * O metodo desempilha os dados da pilha
     * 
     * @return dado que foi desempilhado
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public T desempilhar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha esta vazia");
        }
        T aux = ponteiroTopo.getDado();
        ponteiroTopo = ponteiroTopo.getAnterior();
        quantidade--;
        ponteiroTopo.setProximo(null);
        return aux;
    }

    /**
     * O metodo espia o topo da pilha
     * 
     * @return o dado na posição do topo da pilha.
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public T espiar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha vazia!");
        }
        return ponteiroTopo.getDado();

    }

    /**
     * O metodo atualiza o dado do topo da pilha.
     * 
     * @param o, dado que é atualizado na pilha.
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public void atualizar(T o) {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha vazia!");
        }
        ponteiroTopo.setDado(o);
    }

    /**
     * Verifica se a Pilha esta cheia
     * 
     * @return true, se estiver cheia, false caso
     *         contrario.
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Verifica se a Pilha esta vazia
     * 
     * @return true, se estiver vazia, false caso
     *         contrario.
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Gera uma informação textual dos elementos
     * da pilha
     * 
     * @return texto com os elementos separado
     *         por vírgulas e delimitados por colchetes
     * 
     */
    @Override
    public String imprimir() {
        String retorno = "[";
        NodoDuplo<T> aux = ponteiroTopo;
        for (int i = 0; i < quantidade; i++) {
            retorno += aux.getDado();
            if (i != quantidade - 1) {
                retorno += " , ";
            }
            aux = aux.getAnterior();
        }
        return retorno + "]";

    }

}
