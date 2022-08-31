package dev.titans.daycare;

import dev.titans.entities.Behavior;
import dev.titans.entities.Grade;
import dev.titans.entities.Student;
import dev.titans.repos.GradeRepo;
import dev.titans.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class GradeRepoTests {

    @Autowired
    GradeRepo gradeRepo;
    @Autowired
    StudentRepo studentRepo;

    @Test
    void delete_grade(){
        // need a student in the DB in order to create a grade
        Student student = new Student(0,"Beast","Boy","Batman");
        Student savedStudent = studentRepo.save(student);
        // need to save a grade in the DB to delete it
        Grade grade = new Grade(0,savedStudent.getS_id(),0,"Beast boy behaved well today!", Behavior.GOOD);
        Grade savedGrade = gradeRepo.save(grade);

        gradeRepo.deleteById(savedGrade.getG_id());
        // will attempt to retrieve the deleted grade, and expect nothing to be there, throwing an error
        Assertions.assertThrows(JpaObjectRetrievalFailureException.class,()->{
            Grade deletedGrade = gradeRepo.getReferenceById(savedGrade.getG_id());
        });
    }
}
