package com.example.desafio.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.todolist.model.Todo;

public interface ToDoRepository extends JpaRepository<Todo, Long> {
    
}
