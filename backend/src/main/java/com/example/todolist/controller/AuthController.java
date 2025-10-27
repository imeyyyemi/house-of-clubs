package com.example.todolist.controller;

import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user, HttpSession session) {
        try {
            User newUser = authService.register(user);
            session.setAttribute("user", newUser);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
        try {
            User authenticatedUser = authService.login(user.getUsername(), user.getPassword());
            session.setAttribute("user", authenticatedUser);
            return ResponseEntity.ok(authenticatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("{\"message\": \"Logged out\"}");
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(401).body("{\"error\": \"Not logged in\"}");
    }
}