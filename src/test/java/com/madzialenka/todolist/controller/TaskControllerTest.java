package com.madzialenka.todolist.controller;

import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;
import com.madzialenka.todolist.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
class TaskControllerTest {

    private TaskController underTest;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = Mockito.mock(TaskService.class);
        underTest = new TaskController(taskService);
    }

    @Test
    void deleteTask() {
        long id = 1L;
        underTest.deleteTask(id);
        Mockito.verify(taskService).deleteTask(id);
    }

    @Test
    void getTasks() {
        Sort.Direction direction = Sort.Direction.ASC;
        String sortBy = "field";
        List<TaskResponseDTO> expected = Arrays.asList(
                Mockito.mock(TaskResponseDTO.class),
                Mockito.mock(TaskResponseDTO.class)
        );
        Mockito.when(taskService.getTasks(sortBy, direction)).thenReturn(expected);
        List<TaskResponseDTO> actual = underTest.getTasks(sortBy, direction);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createTask() {
        TaskRequestDTO taskRequestDTO = Mockito.mock(TaskRequestDTO.class);
        TaskResponseDTO expected = Mockito.mock(TaskResponseDTO.class);
        Mockito.when(taskService.createTask(taskRequestDTO)).thenReturn(expected);
        TaskResponseDTO actual = underTest.createTask(taskRequestDTO);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateTask() {
        TaskRequestDTO taskRequestDTO = Mockito.mock(TaskRequestDTO.class);
        Long id = 1L;
        TaskResponseDTO expected = Mockito.mock(TaskResponseDTO.class);
        Mockito.when(taskService.updateTask(id, taskRequestDTO)).thenReturn(expected);
        TaskResponseDTO actual = underTest.updateTask(id, taskRequestDTO);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteTasks() {
        List<Long> ids = Arrays.asList(1L, 2L);
        underTest.deleteTasks(ids);
        Mockito.verify(taskService).deleteTasks(ids);
    }
}