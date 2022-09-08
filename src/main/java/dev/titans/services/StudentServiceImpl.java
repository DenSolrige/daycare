package dev.titans.services;

import dev.titans.exceptions.StudentNotFoundException;
import dev.titans.entities.Student;
import dev.titans.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<Student> getStudentsByName(String name) {
        String[] nameArray = name.split("\\s+");
        Set<Student> students = new HashSet<>();
        for(String n: nameArray){
            students.addAll(this.studentRepo.findByFirstNameOrLastName(n,n));
        }
        return new ArrayList<>(students);
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepo.findAll();
    }

    @Override
    public List<Student> getStudentsByGuardianUsername(String username) {
        return this.getStudentsByGuardianUsername(username);
    }
}
