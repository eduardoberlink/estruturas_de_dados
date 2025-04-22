<?php

class Paciente {
    public string $nome;
    public int $gravidade; // menor valor = mais urgente

    public function __construct(string $nome, int $gravidade) {
        $this->nome = $nome;
        $this->gravidade = $gravidade;
    }
}

class EmergenciaHeap extends SplHeap {
    protected function compare($a, $b): int {
        return $b->gravidade - $a->gravidade; // menor gravidade no topo
    }
}

// Criando heap e adicionando pacientes
$emergencia = new EmergenciaHeap();
$emergencia->insert(new Paciente("Ana", 3));
$emergencia->insert(new Paciente("João", 1));
$emergencia->insert(new Paciente("Carlos", 2));

echo "Ordem de atendimento (mais urgente primeiro):\n";
while (!$emergencia->isEmpty()) {
    $paciente = $emergencia->extract();
    echo "- {$paciente->nome} (gravidade: {$paciente->gravidade})\n";
}