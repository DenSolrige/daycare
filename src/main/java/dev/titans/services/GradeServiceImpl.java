package dev.titans.services;

import dev.titans.entities.Behavior;
import dev.titans.entities.Grade;
import dev.titans.repos.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    GradeRepo gradeRepo;

    @Override
    public Grade addGrade(Grade grade) {
       Grade savedGrade = this.gradeRepo.save(grade);
       return savedGrade;


    }

    @Override
    public List<Grade> getAllGrades() {
       List<Grade> grades = this.gradeRepo.findAll();
       return grades;
    }

    @Override
    public List<Grade> getGradeByBehavior(Behavior behavior) {
        return this.gradeRepo.getGradeByBehavior(behavior);
    }
}
