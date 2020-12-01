package com.madzialenka.todolist.service;

import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    List<TaskResponseDTO> getTasks();

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);
}
