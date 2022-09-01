package dev.titans.controllers;

import dev.titans.entities.Behavior;
import dev.titans.entities.Grade;
import dev.titans.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RestController
public class GradeController {

    @Autowired
    GradeService gradeService;


    @PostMapping("/grades")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade body) {
        Grade savedGrade = this.gradeService.addGrade(body);
        return new ResponseEntity<Grade>(savedGrade, HttpStatus.CREATED);
    }

    @DeleteMapping("/grades/{id}")
    void deleteGradeById(@PathVariable String id){
        int g_id = Integer.parseInt(id);
        this.gradeService.deleteGradeById(g_id);

    }
}

