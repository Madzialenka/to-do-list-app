package com.madzialenka.todolist.db.model;

import javax.persistence.*;
import java.time.LocalDateTime;

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
