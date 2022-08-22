package com.example.todoserver.service;

import com.example.todoserver.model.TodoEntity;
import com.example.todoserver.model.TodoRequest;

import java.util.List;

public interface TodoService {

    TodoEntity add(TodoRequest request);

    TodoEntity searchById(Long id);

    List<TodoEntity> searchAll();

    TodoEntity updateById(Long id, TodoRequest request);

    void deleteById(Long id);

    void deleteAll();

}
