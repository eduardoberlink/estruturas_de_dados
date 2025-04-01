package Fila.FilaComPilha;

public class PilhaEstatica implements Empilhavel {
    private int ponteiroTopo;
    private Object[] dados;

    public PilhaEstatica() {
        this(10);
    }

    public PilhaEstatica(int tamanho) {
        this.ponteiroTopo = -1;
        dados = new Object[tamanho];
    }

    // metodos principais
    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        } else {
            System.out.println("Stack is full!");
        }
    }

    @Override
    public Object espiar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroTopo];
        } else {
            System.out.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public void atualizar(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.out.println("Stack is empty!");
        }
    }

    @Override
    public Object desempilhar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroTopo];
            ponteiroTopo--;
        } else {
            System.out.println("Stack is empty!");
        }
        return aux;
    }

    // metodos auxiliares

    @Override
    public boolean estaCheia() {
        return ponteiroTopo == dados.length -1;
    }

    @Override
    public boolean estaVazia() {
        return ponteiroTopo == -1;
    }

    @Override
    public String imprimir() {
        String retorno = "[";
        for (int i = ponteiroTopo; i >= 0; i--) {
            if (i == 0 ) {
                retorno += dados[i];
            } else {
                retorno += dados[i] + ",";
            }
        }
        return retorno + "]";
    }

}
