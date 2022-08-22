package com.example.todoserver.service;

import com.example.todoserver.model.TodoEntity;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    //1. 목록 추가
    @Override
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    //2. 목록 조회
    @Override
    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //3. 전체 목록 조회
    @Override
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    //4. 목록 수정
    @Override
    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }
        if (request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if (request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    //5. 목록 삭제
    @Override
    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    //6. 목록 전체 삭제
    @Override
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }




}
