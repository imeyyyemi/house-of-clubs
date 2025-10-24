package com.example.todolist.model; import jakarta.persistence.*;
@Entity @Table(name="Task_steps") public class TaskStep {
    @Id @GeneratedValue private Long id; private String stepText; private boolean completed = false;
    @ManyToOne @JionColumn(name="task_id") private Task task;
    public TaskStep() {} public TaskStep(String stepText, Task task){ this.stepText=stepText; this.task=task; }
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getStepText() { return stepText; } public void setStepText(String stepText) { this.stepText = stepText; }
    public boolean isCompleted() { return completed; } public void setCompleted(boolean completed) { this.completed = completed; }
    public Task getTask() { return task; } public void setTask(Task task) { this.task = task; }
}