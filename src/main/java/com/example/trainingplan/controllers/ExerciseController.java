package com.example.trainingplan.controllers;

import com.example.trainingplan.model.Exercise;
import com.example.trainingplan.repository.ExerciseRepository;
import com.example.trainingplan.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/exercises")
    public String getExercises(Model model){

        List<Exercise> allExercises = exerciseService.findAllExercises();
        model.addAttribute("exercises", allExercises);

        return "exercises";
    }

}
