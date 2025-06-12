package Lista.Listadinamica.src;

/**
 * Implementação de uma lista dinâmica duplamente encadeada genérica.
 * Esta classe implementa uma lista que pode armazenar elementos de qualquer
 * tipo,
 * utilizando uma estrutura de nós duplamente encadeados.
 *
 * @param <T> o tipo dos elementos armazenados na lista
 * @author Eduardo Miranda Berlink Santos
 * @version 1.1
 * @since 2025-06-09
 */
public class ListaDinamicaGenerica<T> implements Listavel<T> {

	private int quantidade;
	private int tamanho;
	private NoDuplo<T> ponteiroInicio;
	private NoDuplo<T> ponteiroFim;

	public ListaDinamicaGenerica() {
		this(10);
	}

	public ListaDinamicaGenerica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

	/**
	 * Adiciona um dado ao fim da lista.
	 * 
	 * @Params: Recebe o dado a ser inserido na lista.
	 * @Return: Não retorna nada.
	 * @throws OverflowException Caso se tente inserir um dado na lista e ela já
	 *                           está cheia.
	 */
	@Override
	public void anexar(T dado) throws OverflowException {
		if (estaCheia()) {
			throw new OverflowException("Lista Cheia!");
		}
		NoDuplo<T> noTemporario = new NoDuplo<>();
		noTemporario.setDado(dado);
		if (!estaVazia()) {
			ponteiroFim.setProximo(noTemporario);
			noTemporario.setAnterior(ponteiroFim);
		} else {
			ponteiroInicio = noTemporario;
		}
		ponteiroFim = noTemporario;
		quantidade++;
	}

	/**
	 * Insere um dado numa posicao específica da lista.
	 * 
	 * @Params: Recebe o dado a ser inserido na lista e a sua posição.
	 * @Return: Não retorna nada.
	 * @throws OverflowException Caso tente inserir um dado na lista e ela já está
	 *                           cheia.
	 */
	@Override
	public void inserir(int posicao, T dado) throws OverflowException {
		if (estaCheia()) {
			throw new OverflowException("Lista Cheia!");
		}
		if (!(posicao >= 0 && posicao <= quantidade)) {
			throw new IndexOutOfBoundsException("Indice Invalido!");
		}
		NoDuplo<T> noTemporario = new NoDuplo<>();
		noTemporario.setDado(dado);

		NoDuplo<T> ponteiroAnterior = null;
		NoDuplo<T> ponteiroProximo = ponteiroInicio;

		for (int i = 0; i < posicao; i++) {
			ponteiroAnterior = ponteiroProximo;
			ponteiroProximo = ponteiroProximo.getProximo();
		}

		if (ponteiroAnterior != null) {
			ponteiroAnterior.setProximo(noTemporario);
			// se o anterior é nulo é pq a insercao está sendo no inicio
		} else {
			ponteiroInicio = noTemporario;
		}

		if (ponteiroProximo != null) {
			ponteiroProximo.setAnterior(noTemporario);
			// se o proximo é nulo é pq a insercao está sendo no fim (append)
		} else {
			ponteiroFim = noTemporario;
		}

		noTemporario.setAnterior(ponteiroAnterior);
		noTemporario.setProximo(ponteiroProximo);

		quantidade++;
	}

	/**
	 * Seleciona o dado que está numa posicao logica informada.
	 * 
	 * @throws UnderflowException
	 * 
	 * @Params: Recebe uma posição de um objeto da lista.
	 * @Return: Retorna o objeto da posição indicada.
	 * @Exception: Não gera exceção.
	 */
	@Override
	public T selecionar(int posicao) throws UnderflowException {
		if (estaVazia()) {
			throw new UnderflowException("Lista Vazia!");
		}
		if (!(posicao >= 0 && posicao < quantidade)) {
			throw new IndexOutOfBoundsException("Indice Invalido!");
		}

		NoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < posicao; i++) {
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return ponteiroAuxiliar.getDado();
	}

	/**
	 * Seleciona todos os dado da ED.
	 * 
	 * @throws UnderflowException
	 * 
	 * @Params: não recebe nada.
	 * @Return: Retorna todos os objetos da Lista.
	 * @Exception: Não gera exceção.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] selecionarTodos() throws UnderflowException {
		if (estaVazia()) {
			throw new UnderflowException("Lista Vazia!");
		}
		T[] dadosTemporario = (T[]) new Object[quantidade];
		NoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < quantidade; i++) {
			dadosTemporario[i] = ponteiroAuxiliar.getDado();
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return dadosTemporario;
	}

	/**
	 * Atualiza o dado de uma posicao logica informada por um novo.
	 * 
	 * @throws UnderflowException
	 * 
	 * @Params: Recebe uma posição de um objeto da lista, e o novo objeto.
	 * @Return: Não retorno nada.
	 * @Exception: Não gera exceção.
	 */
	@Override
	public void atualizar(int posicao, T novoDado) throws UnderflowException {
		if (estaVazia()) {
			throw new UnderflowException("Lista Vazia!");
		}
		if (!(posicao >= 0 && posicao < quantidade)) {
			throw new IndexOutOfBoundsException("Indice Invalido!");
		}

		NoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < posicao; i++) {
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		ponteiroAuxiliar.setDado(novoDado);
	}

	/**
	 * Apaga o dado de uma posicao logica informada.
	 * 
	 * @Params: Recebe uma posição de um objeto da lista.
	 * @Return: O objeto apagado.
	 * @throws UnderflowException: Caso tente-se apagar um dado de uma lista vazia.
	 */
	@Override
	public T apagar(int posicao) throws UnderflowException {
		if (estaVazia()) {
			throw new UnderflowException("Lista Vazia!");
		}
		if (!(posicao >= 0 && posicao < quantidade)) {
			throw new IndexOutOfBoundsException("Indice Invalido!");
		}

		NoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < posicao; i++) {
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}

		NoDuplo<T> ponteiroAnterior = ponteiroAuxiliar.getAnterior();
		NoDuplo<T> ponteiroProximo = ponteiroAuxiliar.getProximo();

		if (ponteiroAnterior != null) {
			ponteiroAnterior.setProximo(ponteiroProximo);
			// remocao do inicio, joga o ponteiro de inicio para o proximo nodo.
		} else {
			ponteiroInicio = ponteiroInicio.getProximo();
		}
		if (ponteiroProximo != null) {
			ponteiroProximo.setAnterior(ponteiroAnterior);
			// remocao do fim, joga o ponteiro de fim para o nodo anterior.
		} else {
			ponteiroFim = ponteiroFim.getAnterior();
		}

		quantidade--;
		return ponteiroAuxiliar.getDado();
	}

	/**
	 * Informa se a lista está cheia.
	 * 
	 * @Params: Não recebe nada.
	 * @Return: Um valor lógico informando se a lista está cheia ou não.
	 * @Exception: Não gera exceção.
	 */
	@Override
	public boolean estaCheia() {
		return (quantidade == tamanho);
	}

	/**
	 * Informa se a lista está vazia.
	 * 
	 * @Params: Não recebe nada.
	 * @Return: Um valor lógico informando se a lista está vazia ou não.
	 * @Exception: Não gera exceção.
	 */
	@Override
	public boolean estaVazia() {
		return (quantidade == 0);
	}

	/**
	 * Imprime o conteúdo da lista.
	 * 
	 * @Params: Não recebe nada.
	 * @Return: Uma string com todos os dados da lista separados por ",".
	 * @Exception: Não gera exceção.
	 */
	@Override
	public String imprimir() {
		String resultado = "[";
		NoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < quantidade; i++) {
			if (i == quantidade - 1) {
				resultado += ponteiroAuxiliar.getDado();
			} else {
				resultado += ponteiroAuxiliar.getDado() + ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return resultado + "]";
	}
}
