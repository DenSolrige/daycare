package dev.titans.controllers;

import dev.titans.entities.Behavior;
import dev.titans.entities.Grade;
import dev.titans.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RestController
public class GradeController {

    @Autowired
    GradeService gradeService;


    @GetMapping("/grades")
    public List<Grade> allgrades(@RequestParam(required = false) Behavior behavior) {
        if (behavior == null) {
            return gradeService.getAllGrades();
        } else {
            return gradeService.getGradeByBehavior(behavior);
        }
    }

    @PostMapping("/grades")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade body) {
        Grade savedGrade = this.gradeService.addGrade(body);
        return new ResponseEntity<Grade>(savedGrade, HttpStatus.CREATED);

    @DeleteMapping("/grades/{id}")
    @ResponseBody
    void deleteGradeById(@PathVariable String id){
        int g_id = Integer.parseInt(id);
        this.gradeService.deleteGradeById(g_id);

    }
}

