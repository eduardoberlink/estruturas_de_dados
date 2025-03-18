package Pilha.pilhaEstatica.PilhaInvertida;

public class PilhaInvertidaPrincipal {
    public static void main(String args[]) {
		Empilhavel pilha = new PilhaInvertida(7);
		pilha.push("Instituto");
		pilha.push("Federal");
		System.out.println("peek:" + pilha.peek());		
		pilha.push("de");
		pilha.push("Educação");
		pilha.push("Ciência");
		pilha.push("e");		
		System.out.println("peek:" + pilha.peek());		
		Object conteudo = pilha.pop();
		pilha.pop();
		pilha.push("Tecnologia");
		pilha.push("da");
		pilha.push("Bahia");
		pilha.update("São Paulo");		
		pilha.push(pilha.pop());
		pilha.push(conteudo);
		System.out.println("Pilha="+pilha.print());
	}
}
