package com.example.todoserver.controller;

import com.example.todoserver.model.TodoEntity;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.model.TodoResponse;
import com.example.todoserver.service.TodoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        System.out.println("CREATE");
        if (ObjectUtils.isEmpty(request.getTitle())) {
            return ResponseEntity.badRequest().build();
        }
        if (ObjectUtils.isEmpty(request.getOrder())) {
            request.setOrder(0L);
        }
        if(ObjectUtils.isEmpty(request.getCompleted())) {
            request.setCompleted(false);
        }
        TodoEntity result = this.todoService.add(request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        System.out.println("READ ONE");
        TodoEntity result = this.todoService.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoEntity>> readAll() {
        System.out.println("READ ALL");
        List<TodoEntity> list = this.todoService.searchAll();
        return ResponseEntity.ok(list);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoEntity> update(@PathVariable Long id, @RequestBody TodoRequest request) {
        System.out.println("UPDATE");
        TodoEntity result = this.todoService.updateById(id, request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        System.out.println("DELETE");
        this.todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<TodoEntity> deleteAll() {
        System.out.println("DELETE ALL");
        this.todoService.deleteAll();
        return ResponseEntity.ok().build();
    }


}
