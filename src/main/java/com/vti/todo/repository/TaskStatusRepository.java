package com.vti.todo.repository;

import com.vti.todo.entity.TaskEntity;
import com.vti.todo.entity.TaskStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatusEntity, Integer> {
}
