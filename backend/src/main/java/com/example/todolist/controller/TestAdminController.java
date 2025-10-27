package com.example.todolist.controller;
import com.example.todolist.model.Admin; import
        com.example.todolist.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired; import
        org.springframework.stereotype.Controller; import
        org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestAdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/setup-admin")
    public String setupAdmin() {
        adminRepository.save(new Admin("admin,""1234")); return "redirect:/api/login";
    }
}