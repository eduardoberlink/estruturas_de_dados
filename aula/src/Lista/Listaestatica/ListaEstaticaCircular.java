package Lista.Listaestatica;
public class ListaEstaticaCircular implements Listavel {

    private Object[] dados;
    private int quantidade;
    private int ponteiroInicio;
    private int ponteiroFim;

    public ListaEstaticaCircular(){
        this(10);
    }
    public ListaEstaticaCircular(int tamanho){
        this.quantidade = 0;
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.dados = new Object[tamanho];
    }


    //metodos principais

    @Override
    public void anexar(Object dado) {
        if(!estaCheia()){
                ponteiroFim = avancar(ponteiroFim);
                dados[ponteiroFim] = dado;
                quantidade++;
            }else{
            System.out.println("Lista esta cheia.");
        }
    }
    @Override
    public void inserir(int posicao, Object dado) {
        if(!estaCheia()){
            if(posicao >= 0 && posicao <= quantidade){
                int posicaoFisica = mapeamento(posicao);
                int x = ponteiroFim;
                int y = avancar(x);
                for(int i = 0; i < quantidade - posicao; i++){
                    dados[x] = dados[y];
                    x = retroceder(x);
                    y = retroceder(y);
                }
                dados[posicaoFisica] = dado;
                quantidade++;
                avancar(ponteiroFim);
            }else{
                System.out.println("Posicao invalida!");
            }
        }else{
            System.out.println("Lista esta cheia!");
        }
    }
    @Override
    public Object selecionar(int posicao) {
       Object aux = null;
       if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                aux = dados[posicaoFisica];
            }
       }else{
        System.out.println("Lista esta vazia.");
       }
       return aux;
    }
    @Override
    public Object[] selecionarTodos() {
        Object[] aux = new Object[quantidade];
        int ponteiroAux = ponteiroInicio;
         if(!estaVazia()){
            for(int i = 0; i <= quantidade; i++){
                aux[i] = dados[ponteiroAux];
                ponteiroAux = avancar(ponteiroAux);
            }
        }else{
            System.out.println("Lista esta vazia!");
        }
        return aux;
    }
    @Override
    public void atualizar(int posicao, Object dado) {
       if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                dados[posicaoFisica] = dado;
            }else{
                System.out.println("index invalido");
            }
       }else{
        System.out.println("Lista esta vazia!");
       }
    }
    @Override
    public Object apagar(int posicao) {
        Object aux = null;
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                aux = dados[posicaoFisica];
                int x = posicaoFisica;
                int y = avancar(x);
                for(int i =0; i < quantidade - posicao - 1; i++){
                    dados[x] = dados[y];
                    x = avancar(x);
                    y = avancar(y);
                }
                quantidade --;
                ponteiroFim = retroceder(ponteiroFim);
            }
        }else{
            System.out.println("Lista vazia.");
        }
        return aux;
    }
    @Override
    public void limpar(){
        this.quantidade = 0;
        this.ponteiroFim = -1;
        this.ponteiroInicio = 0;
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
        for(int i = 0; i < quantidade; i++){
            if(i == quantidade - 1){
                retorno += dados[i % dados.length];
            }else{
                retorno += dados[i % dados.length]+ ",";;
            }
        }
       return retorno + "]";
    }
    
    public int avancar(int ponteiro) {
		return (ponteiro + 1) % dados.length;
	}
	public int retroceder(int ponteiro) {
		return ((ponteiro -1)+dados.length) % dados.length;
	}

	// precisa fazer um mapeamento do lógico pra fisico, o usuariio entente que o
	// primeiro indice é o 1 e o array começa em 0
	public int mapeamento(int logica) {
		return (logica + ponteiroInicio) % dados.length;
	}


    /* 
    FAZER EM CASA E TENTAR DEIXAR O APAGAR E O INSERIR EFICIENTE
	public int primeiraOcorrencia(Object dado){
		if(!estaVazia()){
			for(int i=0;i<quantidade;i++){

			}
		}

	}
	public boolean contem(Object dado){

	}
	public boolean comparator(Object dado){

	}*/


}
