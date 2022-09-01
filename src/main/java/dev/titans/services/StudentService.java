package dev.titans.services;

import dev.titans.entities.Student;

public interface StudentService {
    public void deleteStudentById(int id);
    Student createStudent(Student student);
}
