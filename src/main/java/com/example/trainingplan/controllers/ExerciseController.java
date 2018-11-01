package com.example.trainingplan.controllers;

import com.example.trainingplan.model.Exercise;
import com.example.trainingplan.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class ExerciseController {

    // Controller nie powinien sie bezposrednio komunikowac z repository
    // pomiedzy nimi powinien byc service
    // przydaje sie gdy chcemy np exercise troche odchudzic, albo polaczyc z inna klasa
    @Autowired
    ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    public String getExercises(Model model){

        List<Exercise> allExercises = exerciseRepository.findAll();
        model.addAttribute("exercises", allExercises);

        return "exercises";
    }

}
