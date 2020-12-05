package com.madzialenka.todolist.service;

import com.madzialenka.todolist.db.model.Task;
import com.madzialenka.todolist.db.repository.TaskRepository;
import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return taskRepository.findAllByOrderByIdAsc().stream()
                .map(this::mapToTaskResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        setTaskFields(taskRequestDTO, task);
        Task savedTask = taskRepository.save(task);
        return mapToTaskResponseDTO(savedTask);
    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        Task foundTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
        setTaskFields(taskRequestDTO, foundTask);
        Task savedTask = taskRepository.save(foundTask);
        return mapToTaskResponseDTO(savedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteTasks(List<Long> ids) {
        taskRepository.deleteByIdIn(ids);
    }

    private void setTaskFields(TaskRequestDTO taskRequestDTO, Task task) {
        task.setDescription(taskRequestDTO.getDescription());
        task.setTaskStatus(taskRequestDTO.getTaskStatus());
        task.setModificationTime(LocalDateTime.now());
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
