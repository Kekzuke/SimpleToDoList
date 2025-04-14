package com.Kekzuke.app.SimpleToDoList.Repo;

import com.Kekzuke.app.SimpleToDoList.Models.Task;
import com.Kekzuke.app.SimpleToDoList.Models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
