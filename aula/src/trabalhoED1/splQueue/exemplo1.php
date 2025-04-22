<?php

class FilaDeAtendimento {
    private SplQueue $fila;

    public function __construct() {
        $this->fila = new SplQueue();
    }

    public function entrarNaFila(string $cliente) {
        $this->fila->enqueue($cliente);
        echo "$cliente entrou na fila." . PHP_EOL;
    }

    public function atenderProximo() {
        if (!$this->fila->isEmpty()) {
            $cliente = $this->fila->dequeue();
            echo "Atendendo: $cliente" . PHP_EOL;
        } else {
            echo "Fila vazia. Nenhum cliente para atender." . PHP_EOL;
        }
    }

    public function mostrarFila() {
        echo "Fila atual: ";
        foreach ($this->fila as $cliente) {
            echo $cliente . " ";
        }
        echo PHP_EOL;
    }
}

// --- Testando a fila de atendimento ---

$fila = new FilaDeAtendimento();

$fila->entrarNaFila("João");
$fila->entrarNaFila("Maria");
$fila->entrarNaFila("Carlos");

$fila->mostrarFila();

$fila->atenderProximo(); // João
$fila->mostrarFila();

$fila->atenderProximo(); // Maria
$fila->atenderProximo(); // Carlos
$fila->atenderProximo(); // Vazia