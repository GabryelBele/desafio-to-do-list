package com.example.desafio.todolist.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.todolist.dto.ToDoDto;
import com.example.desafio.todolist.model.Todo;
import com.example.desafio.todolist.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public List<Todo> create(@RequestBody Todo todo) {
        return toDoService.create(todo);
    }

    @GetMapping
    public List<Todo> list(Todo todo) {
        return toDoService.list();
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable(value = "id") Long id ,@RequestBody ToDoDto toDoDto) {
        return toDoService.updateToDo(id,toDoDto);
    }

    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable(value = "id") Long id) {
        return toDoService.delete(id);
    }

   
}
