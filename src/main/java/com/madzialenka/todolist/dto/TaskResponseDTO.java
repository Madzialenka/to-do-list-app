package com.madzialenka.todolist.dto;

import com.madzialenka.todolist.model.TaskStatus;

import java.time.LocalDateTime;

public class TaskResponseDTO {
    private Long id;
    private String description;
    private TaskStatus taskStatus;
    private LocalDateTime modificationTime;

    public TaskResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }
}
