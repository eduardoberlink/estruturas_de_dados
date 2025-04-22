<?php

class EditorTexto {
    private string $conteudo = "";
    private SplStack $historico;

    public function __construct() {
        $this->historico = new SplStack();
    }

    public function digitar(string $texto) {
        // Salva o estado atual antes de modificar
        $this->historico->push($this->conteudo);
        $this->conteudo .= $texto;
    }

    public function desfazer() {
        if (!$this->historico->isEmpty()) {
            $this->conteudo = $this->historico->pop();
        } else {
            echo "Nada para desfazer!" . PHP_EOL;
        }
    }

    public function mostrarConteudo() {
        echo "Conteúdo atual: \"$this->conteudo\"" . PHP_EOL;
    }
}

// --- Testando o editor com undo usando SplStack ---

$editor = new EditorTexto();

$editor->digitar("Olá");
$editor->mostrarConteudo(); // Olá

$editor->digitar(", mundo!");
$editor->mostrarConteudo(); // Olá, mundo!

$editor->desfazer();
$editor->mostrarConteudo(); // Olá

$editor->desfazer();
$editor->mostrarConteudo(); // (vazio)

$editor->desfazer(); // Nada para desfazer!