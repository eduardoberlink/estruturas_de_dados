<?php

class Lanchonete {
    private SplQueue $pedidos;

    public function __construct() {
        $this->pedidos = new SplQueue();
    }

    public function fazerPedido(string $pedido) {
        $this->pedidos->enqueue($pedido);
        echo "Pedido recebido: $pedido" . PHP_EOL;
    }

    public function prepararPedido() {
        if (!$this->pedidos->isEmpty()) {
            $pedido = $this->pedidos->dequeue();
            echo "Preparando: $pedido" . PHP_EOL;
        } else {
            echo "Nenhum pedido na fila." . PHP_EOL;
        }
    }

    public function pedidosPendentes() {
        echo "Pedidos na fila: ";
        foreach ($this->pedidos as $pedido) {
            echo $pedido . " | ";
        }
        echo PHP_EOL;
    }
}

// --- Testando a lanchonete ---

$lanche = new Lanchonete();

$lanche->fazerPedido("X-Burger");
$lanche->fazerPedido("Batata Frita");
$lanche->fazerPedido("Refrigerante");

$lanche->pedidosPendentes();

$lanche->prepararPedido(); // X-Burger
$lanche->pedidosPendentes();

$lanche->prepararPedido(); // Batata
$lanche->prepararPedido(); // Refri
$lanche->prepararPedido(); // Nenhum
