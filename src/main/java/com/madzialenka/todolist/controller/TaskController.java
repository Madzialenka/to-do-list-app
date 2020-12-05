package com.madzialenka.todolist.controller;

import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;
import com.madzialenka.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponseDTO> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        return taskService.createTask(taskRequestDTO);
    }

    @PutMapping("{id}")
    public TaskResponseDTO updateTask(@PathVariable("id") Long id, @RequestBody TaskRequestDTO taskRequestDTO) {
        return taskService.updateTask(id, taskRequestDTO);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @DeleteMapping
    public void deleteTasks(@RequestParam("id") List<Long> ids) {
        taskService.deleteTasks(ids);
    }
}
