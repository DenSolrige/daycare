package dev.titans.services;

import dev.titans.repos.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    GradeRepo gradeRepo;
}
