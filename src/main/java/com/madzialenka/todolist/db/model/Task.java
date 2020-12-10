package com.madzialenka.todolist.db.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TASK_STATUS", nullable = false)
    private TaskStatus taskStatus;

    @Column(name = "MODIFICATION_TIME", nullable = false)
    private LocalDateTime modificationTime;

    public Task() {
    }

    public Task(Long id, String description, TaskStatus taskStatus, LocalDateTime modificationTime) {
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
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(description, task.description) &&
                taskStatus == task.taskStatus &&
                Objects.equals(modificationTime, task.modificationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, taskStatus, modificationTime);
    }
}
