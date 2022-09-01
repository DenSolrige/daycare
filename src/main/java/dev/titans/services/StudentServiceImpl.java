package dev.titans.services;

import dev.titans.exceptions.StudentNotFoundException;
import dev.titans.entities.Student;
import dev.titans.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo studentRepo;

    //Delete
    @Override
    public void deleteStudentById(int id) throws StudentNotFoundException {
        if(this.studentRepo.existsById(id)){
            this.studentRepo.deleteById(id);
        }
        else{
            throw new StudentNotFoundException();
        }
    }

    @Override
    public Student createStudent(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public List<Student> getStudentsByName(String firstName, String lastName) {
        return this.studentRepo.findByFirstNameAndLastName(firstName,lastName);
    }
}
