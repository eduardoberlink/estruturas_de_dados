package Pilha.pilhaEstatica.PilhaInvertida;

public class PilhaInvertida implements Empilhavel {
    private int ponteiroTopo;
	private Object[] dados;

	public PilhaInvertida(int tamanho) {
		ponteiroTopo = tamanho;
		dados = new Object[tamanho];
	}
	
	public PilhaInvertida() {
		this(10);
	}
	
    //Metodos principais
	@Override
	public void push(Object dado) {
		if(!isFull()) {
			ponteiroTopo--;
			dados[ponteiroTopo] = dado;
		} else {
			System.err.println("Pilha Cheia!");
		}
	}

	@Override
	public void update(Object dado) {
		if(!isEmpty()) {
			dados[ponteiroTopo] = dado;
		} else {
			System.err.println("Pilha Vazia!");
		}
	}
	
	@Override	
	public Object pop() {
		Object dadoTopo = null;
		if(!isFull()) {
			dadoTopo = dados[ponteiroTopo]; 
			ponteiroTopo++;
		} else {
			System.err.println("Pilha Vazia!");
		}
		return dadoTopo;
	}
	
	@Override	
	public Object peek() {
		Object dadoTopo = null;
		if(!isEmpty()) {
			dadoTopo = dados[ponteiroTopo]; 
		} else {
			System.err.println("Pilha Vazia!");
		}
		return dadoTopo;	
	}
	


    //Metodos auxiliares
	@Override
	public boolean isFull() {
		return (ponteiroTopo == 0);
	}
		
	@Override
	public boolean isEmpty() {
		return (ponteiroTopo == dados.length);
	}
		
	@Override
	public String print() {
		String resultado = "[";
		for(int i = ponteiroTopo; i <= dados.length; i++) {
			if (i == dados.length -1) {
				resultado += dados[i];
			}
			else {
				resultado += dados[i] + ",";
			}
		}
		return resultado + "]";
	}
}
