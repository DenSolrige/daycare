package dev.titans.controllers;

import dev.titans.entities.Student;
import dev.titans.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@RequestParam String id){
        int s_id = Integer.parseInt(id);
        this.studentService.deleteStudentById(s_id);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }
}
