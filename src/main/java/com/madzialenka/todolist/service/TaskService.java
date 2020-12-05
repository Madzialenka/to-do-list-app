package com.madzialenka.todolist.service;

import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TaskService {

    List<TaskResponseDTO> getTasks(String sortBy, Sort.Direction direction);

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);

    void deleteTask(Long id);

    void deleteTasks(List<Long> ids);
}
