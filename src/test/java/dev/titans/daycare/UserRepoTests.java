package dev.titans.daycare;

import dev.titans.entities.User;
import dev.titans.repos.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class UserRepoTests {

    @Autowired
    UserRepo userRepo;

    @Test
    void get_users(){
        List<User> users = userRepo.findAll();
        Assertions.assertNotEquals(0,users.size());
    }
}
