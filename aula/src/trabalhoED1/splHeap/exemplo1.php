<?php

class Tarefa {
    public string $descricao;
    public int $prioridade;

    public function __construct(string $descricao, int $prioridade) {
        $this->descricao = $descricao;
        $this->prioridade = $prioridade;
    }
}

class TarefaHeap extends SplHeap {
    protected function compare($a, $b): int {
        return $a->prioridade - $b->prioridade; // maior prioridade no topo
    }
}

// Criando a heap e adicionando tarefas
$tarefas = new TarefaHeap();
$tarefas->insert(new Tarefa("Enviar relatório", 2));
$tarefas->insert(new Tarefa("Corrigir sistema", 5));
$tarefas->insert(new Tarefa("Responder e-mails", 1));

echo "Tarefas em ordem de prioridade:\n";
while (!$tarefas->isEmpty()) {
    $tarefa = $tarefas->extract();
    echo "- {$tarefa->descricao} (prioridade: {$tarefa->prioridade})\n";
}