package com.vorova.task_manager.controller;

import com.vorova.task_manager.model.dto.TaskDto;
import com.vorova.task_manager.model.entity.Task;
import com.vorova.task_manager.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final ModelMapper mapper;
    private final TaskService taskService;

    public TaskController(ModelMapper mapper, TaskService taskService) {
        this.mapper = mapper;
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAll() {
        Long userId = getUserId();
        List<TaskDto> tasks = taskService.getAll(userId)
                .stream()
                .map(x -> mapper.map(x, TaskDto.class))
                .toList();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TaskDto taskDto) {
        var task = mapper.map(taskDto, Task.class);
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<?> update(@RequestBody TaskDto taskDto) {
        var task = mapper.map(taskDto, Task.class);
        taskService.update(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Long getUserId() {
        // todo корректное извлечение id пользователя
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return 4L;
    }

}
