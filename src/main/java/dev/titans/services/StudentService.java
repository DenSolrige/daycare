package dev.titans.services;

import dev.titans.entities.Student;

import java.util.List;

public interface StudentService {
    void deleteStudentById(int id);
    Student createStudent(Student student);
    List<Student> getStudentsByName(String name);
    List<Student> getStudents();
}
