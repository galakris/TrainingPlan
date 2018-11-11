package com.example.trainingplan.controllers;

import com.example.trainingplan.workout.TrainingGoal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TrainingPlanControlller {



    @GetMapping("/createPlan")
    public String createPlan(Model model){
        model.addAttribute("trainingGoal", new TrainingGoal());
        return "create_my_plan";
    }

    @PostMapping("/createPlan")
    public String createPlan(@ModelAttribute TrainingGoal trainingGoal){

        System.out.println(trainingGoal);


        if(trainingGoal.getFrequency() > 3)
            System.out.println("Split");

        return "create_my_plan";
    }

}
