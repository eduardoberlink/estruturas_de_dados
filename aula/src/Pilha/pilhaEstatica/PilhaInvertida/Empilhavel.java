package Pilha.pilhaEstatica.PilhaInvertida;

public interface Empilhavel {
	//métodos principais
	void push(Object dado);	//C
	Object peek();			//R
	void update(Object dado);//U
	Object pop();		//D
	
	//métodos auxiliares
	boolean isFull();
	boolean isEmpty();
	String print();
}
