package Fila.FilaDupla;

public class FilaDuplaTerminacao implements DuplamenteEnfileiravel {

    private int ponteiroInicio,ponteiroFim;
    private Object[] dados;
    private int quantidade;

    public FilaDuplaTerminacao(){
        this(10);
    }
    public FilaDuplaTerminacao(int tamanho){
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
        dados = new Object[tamanho];
    }

    //metodos principais
    @Override
    public void enfileirarInicio(Object dado) {
        if(!estaCheia()){
            ponteiroInicio = ((ponteiroInicio - 1)+dados.length)%dados.length;
            dados[ponteiroInicio] = dado;
        }if(!estaVazia()){
            ponteiroInicio = ponteiroFim;
            quantidade++;
        }else{
            System.out.println("The queue is full");
        }
    }
    @Override
    public void enfileirarFim(Object dado) {
        if(!estaCheia()){
            ponteiroFim = ((ponteiroFim + 1)+dados.length)%dados.length;
            dados[ponteiroFim] = dado;
        }if(!estaVazia()){
            ponteiroFim = ponteiroInicio;
            quantidade++;
        }else{
            System.out.println("The queue is full");
        }
    }
    @Override
    public Object frente() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
        }else{
            System.out.println("The queue is empty!");
        }
        return aux;
    }
    @Override
    public Object tras() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroFim];
        }else{
            System.out.println("The queue is empty");
        }
        return aux;
    }
    @Override
    public void atualizarInicio(Object dado) {
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        }else{
            System.out.println("The queue is empty");
        }
    }
    @Override
    public void atualizarFim(Object dado) {
       if(!estaVazia()){
            dados[ponteiroFim] = dado;
       }else{
        System.out.println("The queue is empty");
       }

    }
    @Override
    public Object desenfileirarInicio() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
            ponteiroInicio = ((ponteiroInicio +1)+dados.length)%dados.length;
            quantidade--;
        }else{
            System.out.println("the queue is empty");
        }
        return aux;
    }
    @Override
    public Object desenfileirarFim() {
       Object aux = null;
       if(!estaVazia()){
        aux = dados[ponteiroFim];
        ponteiroFim = ((ponteiroFim -1)+dados.length)%dados.length;
       }else{
        System.out.println("The queue is empty");
       }
       return aux;
    }
    
    //metodos auxiliares
    
    @Override
    public boolean estaCheia() {
        return quantidade == dados.length;
    }
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }
    @Override
    public String imprimir() {
    String retorno = "[";
    int ponteiroAux = ponteiroInicio;
        for(int i=0;i < quantidade ;i++){
            if(i == quantidade - 1){
                retorno += dados[ponteiroAux];
            }else{
                retorno += dados[ponteiroAux] + ",";
            }

        }   
        return retorno + "]";
    }

}
