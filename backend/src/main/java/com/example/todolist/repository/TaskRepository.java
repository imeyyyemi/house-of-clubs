package com.example/.todolist.repository;

import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository ectends JpaRepository<Task, Long> {
    // Find tasks by house (CLUBS only)
    List<Task> findByHouseId(Long houseId);

    //Find completed tasks (for CLUBS score!)
    List<Task> findByCompletedTrue();

    //Find incomplete tasks (for students)
    List<Task> findByCompletedFalse();

    //Find by title (search "Clean Room")
    List<Task> findByTitleContainingIgnoreCase(String title);
}
//test