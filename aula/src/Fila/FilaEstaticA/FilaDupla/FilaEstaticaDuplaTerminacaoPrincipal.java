package Fila.FilaEstaticA.FilaDupla;

public class FilaEstaticaDuplaTerminacaoPrincipal {
	public static void main(String[] args) {
		DuplamenteEnfileiravel fila = new FilaDuplaTerminacao();
		fila.enfileirarInicio("A");
		System.out.println(fila.imprimirFrenteTras()); // [A]
		System.out.println(fila.tras()); // A
		System.out.println(fila.frente()); // A
		fila.enfileirarInicio("B");
		fila.desenfileirarFim();
		fila.enfileirarFim("C");
		fila.atualizarInicio("Y");
		fila.desenfileirarInicio();
		fila.enfileirarInicio("D");
		System.out.println(fila.imprimirTrasFrente()); // [C,D]
		fila.frente();
		fila.desenfileirarFim();
		System.out.println(fila.tras()); // D
		fila.enfileirarInicio("E");
		fila.atualizarFim("R");
		System.out.println(fila.imprimirTrasFrente());// [R,E]
		fila.enfileirarFim("F");
		fila.desenfileirarInicio();
		fila.enfileirarFim("G");
		System.out.println(fila.tras()); // G
		fila.enfileirarInicio("H");
		fila.desenfileirarFim();
		fila.enfileirarFim("I");
		System.out.println(fila.imprimirFrenteTras()); // [H,R,F,I]
		fila.enfileirarInicio("J");
		fila.enfileirarFim("K");
		fila.enfileirarFim("L");
		System.out.println(fila.frente()); // J
		fila.desenfileirarInicio();
		System.out.println(fila.imprimirFrenteTras()); // [H,R,F,I,K,L]
	}
}
