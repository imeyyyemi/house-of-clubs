package com.example.todolist.repository; import com.example.todolist.model.House; import org.springframework.data.jpa.repository.JpaRepository;
public interface HouseRepository extends JpaRepository<House, Long> { House findByName(String name); }
