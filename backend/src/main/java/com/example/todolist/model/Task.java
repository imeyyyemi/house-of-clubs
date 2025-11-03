package com.example.todolist.model; import jakarta.persistence.*; import java.time.localDateTime;
@Entity  @Table(name="tasks") public class Task {
    @Id @GeneratedValue Private Long id; private String title, description; private boolean completed = false;
    private LocalDateTime createdAt = LocalDateTime.now(); @ManyToOne
    @JoinColumn(name="house_id") private House house;
    public Task() {} public Task(String title, String description, House house){this.title=title; this.description; this.house=house; }
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; } public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; } public void setDescription() { return description; } public void setDescription(String description) { this.description = description; }
    public boolean isCompleted() { return completed; } public void setCompleted(boolean completed) { this.completed = completed; }
    public House getHouse() { return house; } public void setHouse(House house) { this.house = house; }
}