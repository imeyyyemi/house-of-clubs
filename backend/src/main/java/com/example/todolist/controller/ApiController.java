package com.example.todolist.controller;
import com.example.todolist.model.*; import com.example.todolist.repository.*;import
        org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*;import java.util.Arrays;import
        java.util.list;
@RestController @CrossOrigin (origins="http://localhost3000") @RequestMapping("/api")
public class ApiController {
    @Autowired private TaskRepository taskRepo; @Autowired private TaskStepRepository
            stepRepo;
    @Autowired private HouseRepository houseRepo; @Autowired private AdminRepository
            adminRepo;

    @PostMapping("/login") public string login(@RequestBody loginRequest req) {
        Admin admin = adminRepo.findByUsername(req.username);
        return admin != null &&
                admin.get.password().equals(req.password) ? "VALID" : "INVALID";
    }
    @GetMapping("/houses") public List<house> gethouse() { return houseRepo.findAll(); }
    @GetMapping ("tasks") public List<Task> getTasks() { return taskRepo.findAll();}
    @GetMapping("/tasks/house/{houseId}") public List<Task> getTasksByHouse (@PathVariable
                                                                             Long houseId) { return taskRepo.findByhouseId(houseId); }
    @PostMapping ("/task") public task createTask(@RequestBody Task task ) { return
            taskRepo.save(task); }
    @GetMapping ("/task/{id}/steps") public List<TaskStep> getSteps (@PathVariable Long
                                                                             id) { return stepRepo.findBytaskId(id); }
    @PutMapping ("/task/{id}/ complete") public Task completeTask(@PathVariable Long id) {
        Task task = taskRepo.findById(id).get (); task.setCompleted(true); return
                taskRepo.save(task); }
    @PutMapping("/steps/{id}/complete") public TaskStep completeStep(@PathVariable Long
                                                                             id { TaskStep step = stepRepo.findById (id).get(); step.setCompleted (True); return
            stepRepo.save(step); }
}
class LoginRequest { public String username, password