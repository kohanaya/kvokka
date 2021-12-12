package com.semo.kvokka.controller;

import com.semo.kvokka.entity.Task;
import com.semo.kvokka.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TasksController {

    private final TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getById(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id,
                       @RequestBody Task newTask) {
        var task = taskRepository.findById(id).orElseThrow();
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

}
