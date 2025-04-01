package Fila.FilaComPilha;

public class FilaComPilha implements Enfileiravel {

    private Empilhavel p1;
    private Empilhavel p2;

    public FilaComPilha() {
        this(10);
    }

    public FilaComPilha(int tamanho) {
        p1 = new PilhaEstatica();
        p2 = new PilhaEstatica();

    }

    @Override
    public void enfileirar(Object dado) {
        if (!estaCheia()) {
            while(!p1.estaVazia()){
                p2.empilhar(p1.desempilhar());
            }
            p1.empilhar(dado);
            while(!p2.estaVazia()){
                p1.empilhar(p2.desempilhar());
            }
        } else {
            System.out.println("Queue is full!");
        }
    }

    @Override
    public Object frente() {
        Object aux = null;
        if(!estaVazia()){
            aux = p1.espiar();
        }else{
            System.out.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public void atualizarInicio(Object dado) {

    }

    @Override
    public void atualizarFim(Object dado) {
    }

    @Override
    public Object desenfileirar() {
        Object aux = null;
        if(!estaVazia()){
            aux = p1.desempilhar();
        }else{
            System.out.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public boolean estaCheia() {
        return p1.estaCheia();
    }

    @Override
    public boolean estaVazia() {
        return p1.estaVazia();
    }

    @Override
    public String imprimir() {
       return p1.imprimir();
    }

}
