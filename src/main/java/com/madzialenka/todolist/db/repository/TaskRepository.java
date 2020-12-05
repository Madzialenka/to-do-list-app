package com.madzialenka.todolist.db.repository;

import com.madzialenka.todolist.db.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderByIdAsc();
    void deleteByIdIn(List<Long> ids);
}
