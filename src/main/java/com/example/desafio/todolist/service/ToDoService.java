package com.example.desafio.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.desafio.todolist.model.Todo;
import com.example.desafio.todolist.repository.ToDoRepository;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;

    }

    public List<Todo> create(Todo todo) {
        toDoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return toDoRepository.findAll(sort);
    }

    public List<Todo> updateToDo(Todo todo) {
        toDoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        toDoRepository.deleteById(id);
        return list();
    }
}
