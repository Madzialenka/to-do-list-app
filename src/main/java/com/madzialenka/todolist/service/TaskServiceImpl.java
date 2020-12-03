package com.madzialenka.todolist.service;

import com.madzialenka.todolist.db.model.Task;
import com.madzialenka.todolist.db.repository.TaskRepository;
import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskResponseDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(this::mapToTaskResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setDescription(taskRequestDTO.getDescription());
        task.setTaskStatus(taskRequestDTO.getTaskStatus());
        task.setModificationTime(LocalDateTime.now());
        Task savedTask = taskRepository.save(task);
        return mapToTaskResponseDTO(savedTask);
    }

    private TaskResponseDTO mapToTaskResponseDTO(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setTaskStatus(task.getTaskStatus());
        dto.setModificationTime(task.getModificationTime());
        return dto;
    }
}
