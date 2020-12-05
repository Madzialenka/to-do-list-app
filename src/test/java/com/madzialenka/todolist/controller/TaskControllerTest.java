package com.madzialenka.todolist.controller;

import com.madzialenka.todolist.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        underTest.deleteTask(1L);
        Mockito.verify(taskService).deleteTask(1L);
    }
}