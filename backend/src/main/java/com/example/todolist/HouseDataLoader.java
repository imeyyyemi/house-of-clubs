package com example.todolist;import com.example.todolist.model.House;import
        com.example.todolist.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;import
        org.springframework boot.CommandLineRunner;import
        org.springframework.stereotype.Component;
@Component public class HouseDataLoader implements CommandLineRunner {
    @AutoWired private HouseRepository houseRepo; @Override public void run(string...args)throws Exception {
        if (houseRepo.count() == 0) {
            houseRepo.save(new House("CLUBS", " "));
        }
    }
}
