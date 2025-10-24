package com.example.todolist.model;

public class TaskStepRequest {
    public Long stepId;
    public boolen completed;

    public TaskStepRequest() {}
    public TaskStepRequest(Long stepId, boolen completed){
        this.stepId = stepId;
        this.completed = completed;

    }
}