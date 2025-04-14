package com.Kekzuke.app.SimpleToDoList.Services;

import com.Kekzuke.app.SimpleToDoList.Models.Task;
import com.Kekzuke.app.SimpleToDoList.Models.TaskStatus;
import com.Kekzuke.app.SimpleToDoList.Repo.TaskRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {


    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public String getPage(){
        return "Welcome";
    }

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskRepo.findByStatus(status);
    }

    public String createTask(@RequestBody Task task) {
        task.setCreateDate(LocalDate.now());

        if(task.getStatus() == TaskStatus.Done){
            task.setSolvedDate(LocalDate.now());
        }

        taskRepo.save(task);
        return "Task created";
    }

    public String updateTask(@RequestBody Task task, @PathVariable long id) {
        var updateTask = taskRepo.findById(id).get();

        if(task.getStatus() == TaskStatus.Done){
            updateTask.setSolvedDate(LocalDate.now());
        }

        updateTask.setStatus(task.getStatus());
        updateTask.setDescription(task.getDescription());
        updateTask.setName(task.getName());

        taskRepo.save(updateTask);

        return "Task updated";
    }

    public String deleteTaskRange(@PathVariable String idRange) {
        String[] idArr = idRange.split("-");

        long a = Long.parseLong(idArr[0]);
        long b = Long.parseLong(idArr[1]);

        for(long i = a; i <= b; i++) {
            taskRepo.deleteById(i);
        }

        return "Tasks deleted";
    }

    public String deleteAllTasks() {
        taskRepo.deleteAll();

        return "All tasks deleted";
    }

    public String deleteTask(@PathVariable long id) {
        taskRepo.deleteById(id);

        return "Task deleted";
    }

}
