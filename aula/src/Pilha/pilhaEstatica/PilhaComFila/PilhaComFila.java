package Pilha.pilhaEstatica.PilhaComFila;

public class PilhaComFila implements Empilhavel{
    private Enfileiravel f1;
    private Enfileiravel f2;

    public PilhaComFila(){
        this(10);
    }
    public PilhaComFila(int tamanho){
        f1 = new FilaEstaticaCircular();
        f2 = new FilaEstaticaCircular();
    }
    @Override
    public void empilhar(Object dado) {
        if(!estaCheia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            }
            f1.enfileirar(dado);
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            }
        }else{
            System.out.println("Stack is full!");
        }
    }
    @Override
    public Object espiar() {
        Object aux = null;
        if(!estaVazia()){
            aux = f1.frente();
        }else{
            System.out.println("Stack is empty");
        }
        return aux;
    }
    @Override
    public void atualizar(Object dado) {
       if(!estaVazia()){
            f1.atualizarInicio(dado);
       }else{
        System.out.println("Stack is empty");
       }
    }
    @Override
    public Object desempilhar() {
       Object aux = null;
        if(!estaVazia()){
            aux = f1.desenfileirar();
       }else{
        System.out.println("Stack is empty");
       }
       return aux;
    }
    @Override
    public boolean estaCheia() {
        return f1.estaCheia();
    }
    @Override
    public boolean estaVazia() {
        return f1.estaVazia();
    }
    @Override
    public String imprimir() {
        return f1.imprimir();
    }


    

}
