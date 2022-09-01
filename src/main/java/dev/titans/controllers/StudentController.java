package dev.titans.controllers;

import dev.titans.entities.Student;
import dev.titans.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    @ResponseBody
    public Student createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }
}
