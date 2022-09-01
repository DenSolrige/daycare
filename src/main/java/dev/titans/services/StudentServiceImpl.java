package dev.titans.services;

import dev.titans.entities.Student;
import dev.titans.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student createStudent(Student student) {
        return this.studentRepo.save(student);
    }
}
