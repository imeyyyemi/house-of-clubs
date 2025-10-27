package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getTasks(HttpSession session) {
        String username = ((com.example.todolist.model.User) session.getAttribute("user")).getUsername();
        return taskRepository.findByUserUsername(username);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task, HttpSession session) {
        String username = ((com.example.todolist.model.User) session.getAttribute("user")).getUsername();
        task.setUser(((com.example.todolist.model.User) session.getAttribute("user")));
        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task updatedTask, HttpSession session) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null || !task.getUser().getUsername().equals(((com.example.todolist.model.User) session.getAttribute("user")).getUsername())) {
            return ResponseEntity.notFound().build();
        }
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id, HttpSession session) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null || !task.getUser().getUsername().equals(((com.example.todolist.model.User) session.getAttribute("user")).getUsername())) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.delete(task);
        return ResponseEntity.ok("{\"message\": \"Task deleted\"}");
    }
}