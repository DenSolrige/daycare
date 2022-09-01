package dev.titans.daycare;

import dev.titans.entities.Student;
import dev.titans.repos.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class StudentRepoTests {

    @Autowired
    StudentRepo studentRepo;

    @Test
    void create_student(){
        Student student = new Student(0,"Beast","Boy","Batman");
        Student savedStudent = studentRepo.save(student);
        Assertions.assertNotEquals(0,savedStudent.getStudentId());
    }

    @Test
    void delete_student(){
        Student savedStudent = studentRepo.save(new Student(0, "Burger", "Man", "Chkechn"));
        int id = savedStudent.getStudentId();
        studentRepo.deleteById(id);
        Assertions.assertFalse(studentRepo.existsById(id));
    }

    @Test
    void get_student_by_name(){
        Student savedStudent = studentRepo.save(new Student(0, "Burger", "Man", "Chkechn"));
        List<Student> students = studentRepo.findByFirstNameAndLastName(savedStudent.getFirstName(),savedStudent.getLastName());
        Assertions.assertNotEquals(0,students.size());
    }
}
