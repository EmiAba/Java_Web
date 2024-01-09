package com.plannerapp.model.dto;

import com.plannerapp.model.annotation.StringDateInFuture;
import com.plannerapp.model.enim.PriorityName;
import com.plannerapp.model.entity.Task;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskDto {
        private Long id;
        private String description;

    private String dueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private PriorityName priority;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }

    public static TaskDto createFromTask(Task task) {

        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority().getName());
        taskDto.setDueDate(taskDto.getDueDate());


        return taskDto;
    }

}
