package dev.titans.controllers;

import dev.titans.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @DeleteMapping("/grades/{id}")
    @ResponseBody
    void deleteGradeById(@PathVariable String id){
        int g_id = Integer.parseInt(id);
        this.gradeService.deleteGradeById(g_id);
    }
}
