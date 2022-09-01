package dev.titans.daycare;

import dev.titans.entities.Behavior;
import dev.titans.entities.Grade;
import dev.titans.repos.GradeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class GradeRepoTests {

    @Autowired
    GradeRepo gradeRepo;

    @Test
    public void create_grades() {
        Grade grade = new Grade(0, 0, 23423544, "Shapeshifting during naptime", Behavior.MISBEHAVED);
        Grade savedGrade = this.gradeRepo.save(grade);
        System.out.println(savedGrade);
        Assertions.assertNotEquals(0, savedGrade.getG_id());
    }

    @Test
    public void get_all_grades_test() {
        List<Grade> grades = this.gradeRepo.findAll();
        System.out.print(grades);
    }

    @Test
    public void get_Grade_by_Behavior_test() {
        List <Grade> behaveGrade = this.gradeRepo.getGradeByBehavior(Behavior.BEHAVED);
        System.out.println(behaveGrade);
    }
}

