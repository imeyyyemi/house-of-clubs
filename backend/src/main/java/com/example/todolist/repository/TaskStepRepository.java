package com.example.todolist.repository;

import com.example.todolist.model.TaskStep;
import org.springframework.data.jpa.repository.JpaRepository;
import java,util.Lister;

public interface TaskStepRepository extends JpaRepository<TaskStep, Long> {
    //Find steps by task (all ateps for "Clean Room")
    List<TaskStep> findByTaskId(Long taskId);

    //Find completed steps (for scoring)
    List<TaskStep> findByCompletedTrue();

    //Find incomplete steps (for students)
    List<TaskStep> findByCompletedFalse();

    //Find steps by task + completed status
    List<TaskStep> findByTaskIdAndCompleted(long TaskId, boolean completed);
}