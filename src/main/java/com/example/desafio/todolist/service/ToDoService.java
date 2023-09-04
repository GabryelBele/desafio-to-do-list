package com.example.desafio.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.desafio.todolist.dto.ToDoDto;
import com.example.desafio.todolist.model.Todo;
import com.example.desafio.todolist.repository.ToDoRepository;

import jakarta.persistence.EntityNotFoundException;

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

    public Todo updateToDo(Long id, ToDoDto updatedTodo) {
    Optional<Todo> existingTodoOptional = toDoRepository.findById(id);

    if (existingTodoOptional.isPresent()) {
        Todo existingTodo = existingTodoOptional.get();

        BeanUtils.copyProperties(updatedTodo, existingTodo);
        return toDoRepository.save(existingTodo);
    } else {

        throw new EntityNotFoundException("ToDo com o ID " + id + " não encontrado.");
    }
}


    public List<Todo> delete(Long id) {
        toDoRepository.deleteById(id);
        return list();
    }
}
