package com.Kekzuke.app.SimpleToDoList.Models;
import com.Kekzuke.app.SimpleToDoList.Models.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class ToDoList {

    private long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}

