package com.madzialenka.todolist.dto;

import com.madzialenka.todolist.db.model.TaskStatus;

public class TaskRequestDTO {
    private String description;
    private TaskStatus taskStatus;

    public TaskRequestDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
