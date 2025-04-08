package Lista.Listaestatica;
public interface Listavel {


    void anexar(Object dado);                       //c
    void inserir(int posicao,Object dado);          //c
    Object selecionar(int posicao);                 //r
    Object[] selecionarTodos();                     //r
    void atualizar(int posicao, Object dado);       //u
    void limpar();                                  //u
    Object apagar(int posicao);                     //d

    //metodos auxiliares
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}

