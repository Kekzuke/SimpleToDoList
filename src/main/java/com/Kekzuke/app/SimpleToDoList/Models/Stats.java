package com.Kekzuke.app.SimpleToDoList.Models;

public class Stats {

    private int totalOfTask;

    private int completedTask;

    private int completedTasksPercentage;

    public int getTotalOfTask() {
        return totalOfTask;
    }

    public void setTotalOfTask(int totalOfTask) {
        this.totalOfTask = totalOfTask;
    }

    public int getCompletedTask() {
        return completedTask;
    }

    public void setCompletedTask(int completedTask) {
        this.completedTask = completedTask;
    }

    public int getCompletedTasksPercentage() {
        return completedTasksPercentage;
    }

    public void setCompletedTasksPercentage(int completedTasksPercentage) {
        this.completedTasksPercentage = completedTasksPercentage;
    }
}
