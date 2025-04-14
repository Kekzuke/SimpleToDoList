package com.Kekzuke.app.SimpleToDoList.Controller;

import com.Kekzuke.app.SimpleToDoList.Models.Task;
import com.Kekzuke.app.SimpleToDoList.Models.TaskStatus;
import com.Kekzuke.app.SimpleToDoList.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoAPIController {

    private final TaskService taskService;

    public ToDoAPIController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/")
    public String getPage(){
        return taskService.getPage();
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping(value = "/tasks/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    @PostMapping(value = {"/tasks"})
    public String createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping(value = "/tasks/{id}")
    public String updateTask(@RequestBody Task task, @PathVariable long id) {
        return taskService.updateTask(task, id);
    }

    @DeleteMapping(value = "/tasks/range/{idRange}")
    public String deleteTaskRange(@PathVariable String idRange) {
        return taskService.deleteTaskRange(idRange);
    }

    @DeleteMapping(value = "/tasks")
    public String deleteAllTasks() {
        return taskService.deleteAllTasks();
    }

    @DeleteMapping(value = "/tasks/{id}")
    public String deleteTask(@PathVariable long id) {
        return taskService.deleteTask(id);
    }
}
