package com.madzialenka.todolist.dto;

import com.madzialenka.todolist.db.model.TaskStatus;

import java.util.Objects;

public class TaskRequestDTO {
    private String description;
    private TaskStatus taskStatus;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String description, TaskStatus taskStatus) {
        this.description = description;
        this.taskStatus = taskStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskRequestDTO that = (TaskRequestDTO) o;
        return Objects.equals(description, that.description) &&
                taskStatus == that.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, taskStatus);
    }
}
