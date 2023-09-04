package com.example.desafio.todolist.dto;

public record ToDoDto(String nome, String descricao, boolean realizada, int prioridade) {
    // Não é necessário escrever métodos getters e setters aqui, pois uma record
    // gera automaticamente esses métodos.
}
