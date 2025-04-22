<?php

class Navegador {
    private SplStack $historico;
    private ?string $paginaAtual = null;

    public function __construct() {
        $this->historico = new SplStack();
    }

    public function visitar(string $url) {
        if ($this->paginaAtual !== null) {
            $this->historico->push($this->paginaAtual);
        }
        $this->paginaAtual = $url;
        echo "Visitando: $url" . PHP_EOL;
    }

    public function voltar() {
        if (!$this->historico->isEmpty()) {
            $this->paginaAtual = $this->historico->pop();
            echo "Voltando para: $this->paginaAtual" . PHP_EOL;
        } else {
            echo "Não há páginas anteriores." . PHP_EOL;
        }
    }

    public function paginaAtual() {
        echo "Página atual: " . ($this->paginaAtual ?? "Nenhuma") . PHP_EOL;
    }
}

// --- Testando o navegador ---

$navegador = new Navegador();

$navegador->visitar("google.com");
$navegador->visitar("php.net");
$navegador->visitar("github.com");

$navegador->paginaAtual(); // github.com

$navegador->voltar(); // php.net
$navegador->paginaAtual();

$navegador->voltar(); // google.com
$navegador->paginaAtual();

$navegador->voltar(); // Nenhuma
$navegador->paginaAtual();