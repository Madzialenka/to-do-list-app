package com.madzialenka.todolist.dto;

import com.madzialenka.todolist.db.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class TaskResponseDTO {
    private Long id;
    private String description;
    private TaskStatus taskStatus;
    private LocalDateTime modificationTime;

    public TaskResponseDTO() {
    }

    public TaskResponseDTO(Long id, String description, TaskStatus taskStatus, LocalDateTime modificationTime) {
        this.id = id;
        this.description = description;
        this.taskStatus = taskStatus;
        this.modificationTime = modificationTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskResponseDTO that = (TaskResponseDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                taskStatus == that.taskStatus &&
                Objects.equals(modificationTime, that.modificationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, taskStatus, modificationTime);
    }
}
