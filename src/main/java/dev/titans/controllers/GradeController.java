package dev.titans.controllers;

import dev.titans.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;
}
