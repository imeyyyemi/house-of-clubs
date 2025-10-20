package com.example.todolist.model; import jakarta.persistence.*;
@Entity @Table(name="admins") public class Admin {
    @Id @generatedValue Private Long id; private String username, password;
    public Admin() {} public Admin(String username, Stringpassword){
        this.username=username; this.password=password; }
    public Long getId() {return id; } public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; } Public void setUsername(String username) { this.username = username; }
    public String getPassword(){ return password; } public void setPassword(String password){ this.password = password; }
}

