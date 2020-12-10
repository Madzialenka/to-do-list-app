package com.madzialenka.todolist.service;

import com.madzialenka.todolist.db.model.Task;
import com.madzialenka.todolist.db.model.TaskStatus;
import com.madzialenka.todolist.db.repository.TaskRepository;
import com.madzialenka.todolist.dto.TaskRequestDTO;
import com.madzialenka.todolist.dto.TaskResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
class TaskServiceImplTest {

    private TaskServiceImpl underTest;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
        underTest = new TaskServiceImpl(taskRepository);
    }

    @Test
    void getTasks() {
        String sortBy = "field";
        Sort.Direction direction = Sort.Direction.ASC;
        LocalDateTime time = LocalDateTime.now();

        List<Task> tasks = Arrays.asList(
            new Task(1L, "abc", TaskStatus.DONE, time),
            new Task(2L, "def", TaskStatus.IN_PROGRESS, time)
        );
        Mockito.when(taskRepository.findAll(Sort.by(direction, sortBy))).thenReturn(tasks);

        List<TaskResponseDTO> expected = Arrays.asList(
                new TaskResponseDTO(1L, "abc", TaskStatus.DONE, time),
                new TaskResponseDTO(2L, "def", TaskStatus.IN_PROGRESS, time)
        );

        List<TaskResponseDTO> actual = underTest.getTasks(sortBy, direction);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createTask() {
        String description = "field";
        TaskStatus taskStatus = TaskStatus.DONE;
        TaskRequestDTO taskRequestDTO = new TaskRequestDTO(description, taskStatus);
        LocalDateTime time = LocalDateTime.now();
        Long id = 1L;

        Task savedTask = new Task(id, description, taskStatus, time);
        Mockito.when(taskRepository.save(ArgumentMatchers.argThat(task -> description.equals(task.getDescription())
                && taskStatus.equals(task.getTaskStatus())))).thenReturn(savedTask);

        TaskResponseDTO expected = new TaskResponseDTO(id, description, taskStatus, time);

        TaskResponseDTO actual = underTest.createTask(taskRequestDTO);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void deleteTasks() {
    }
}