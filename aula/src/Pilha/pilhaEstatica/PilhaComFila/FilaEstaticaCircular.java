package Pilha.pilhaEstatica.PilhaComFila;


public class FilaEstaticaCircular implements Enfileiravel {
    private int ponteiroInicio, ponteiroFim, quantidade;
    private Object[] dados;

    public FilaEstaticaCircular() {
        this(10);
    }

    public FilaEstaticaCircular(int tamanho) {
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
        dados = new Object[tamanho];
    }

    @Override
    public void enfileirar(Object dado) {
        if(!estaCheia()){
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
        }else{
            System.out.println("Queue is full!");
        }
    }

    @Override
    public Object frente() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
        }else{
            System.out.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public void atualizarInicio(Object dado) {
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        }else{
            System.out.println("Queue is empty!");
        }


    }

    @Override
    public void atualizarFim(Object dado) {
        if(!estaVazia()){
            dados[ponteiroFim] = dado;
        }else{
            System.out.println("Queue is empty!");
        }
    }

    @Override
    public Object desenfileirar() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio]; 
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
        }else{
            System.out.println("Queue is empty! ");
        }
        return aux;
    }

    @Override
    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimir(){
		String retorno = "[";
		int ponteiroAux = ponteiroInicio;
		for (int i = 0; i < quantidade; i++) {			
			if (i == quantidade - 1) 
				retorno += dados[ponteiroAux];
			else
				retorno += dados[ponteiroAux] + ",";
			
			ponteiroAux = avancar(ponteiroAux); 
		}
		return retorno + "]";	
	}



    public int avancar(int ponteiro){
        return (ponteiro + 1)%dados.length;
    }

}
