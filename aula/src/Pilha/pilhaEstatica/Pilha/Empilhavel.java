package Pilha.pilhaEstatica.Pilha;


public interface Empilhavel {
/*
    Operações principais
    1-Empilhar//push
    2-Desempilhar//pop
    3-Topo//top
    4-update
    Operações Auxiliares
    5-estaCheia//isFull //overFlow
    6-estaVazia//isEmpty //underFlow
    7-imprimir//print
    */

    void push(Object o);
    Object pop();
    //Object top();
    boolean isFull();
    boolean isEmpty();
    Object peek();
    //duas formas:
    String print();
    //void print();
    void update(Object o);
  
} 

 /*
     C - create
     R - read
     U - update
     D - delete
     S - sort
     */
    
    
    //chamada do metodo
    //pilha.pop();
    /*
     Tipos de Dados:
     number,object...
     integer,float,ponto fixo,double,long.
     String,char.
     boolean.
     */