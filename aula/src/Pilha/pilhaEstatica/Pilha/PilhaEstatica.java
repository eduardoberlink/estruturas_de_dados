package Pilha.pilhaEstatica.Pilha;
public class PilhaEstatica implements Empilhavel {
    private int ponteiroTopo;
	private Object[] dados;

	public PilhaEstatica(int tamanho) {
		ponteiroTopo = -1;
		dados = new Object[tamanho];
	}
	
	public PilhaEstatica() {
		this(10);
	}
	
    //Metodos principais
	@Override
	public void push(Object dado) {
		if(!isFull()) {
			ponteiroTopo++;
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
			ponteiroTopo--;
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
		return (ponteiroTopo == dados.length - 1);
	}
		
	@Override
	public boolean isEmpty() {
		return (ponteiroTopo == -1);
	}
		
	@Override
	public String print() {
		String resultado = "[";
		for(int i = ponteiroTopo; i >= 0; i--) {
			if (i == 0) {
				resultado += dados[i];
			}
			else {
				resultado += dados[i] + ",";
			}
		}
		return resultado + "]";
	}
}
