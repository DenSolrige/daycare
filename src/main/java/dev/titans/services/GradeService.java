package dev.titans.services;

import dev.titans.entities.Grade;

import java.util.List;

public interface GradeService {

    Grade addGrade(Grade grade);

    List<Grade> getAllGrades();
    List<Grade> getGradesByStudentId(int id);

    void deleteGradeById(int id);
}
