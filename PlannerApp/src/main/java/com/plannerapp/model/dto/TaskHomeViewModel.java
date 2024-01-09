package com.plannerapp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {
    private List<TaskDto> availableTasks;
    private List<TaskDto> assignedTasks;
    private int availableSize;

    public TaskHomeViewModel() {
        this(new ArrayList<>(), new ArrayList<>());

    }

    public TaskHomeViewModel(List<TaskDto> assignedTasks, List<TaskDto> availableTasks) {
        this.assignedTasks=assignedTasks;
       this. availableTasks=availableTasks;
       this.availableSize=assignedTasks.size();
    }


    public List<TaskDto> getAvailableTasks() {
        return availableTasks;
    }

    public void setAvailableTasks(List<TaskDto> availableTasks) {
        this.availableTasks = availableTasks;
    }

    public List<TaskDto> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<TaskDto> assignedTasksToMe) {
        this.assignedTasks = assignedTasksToMe;
    }

    public int getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(int availableSize) {
        this.availableSize = availableSize;
    }
}
