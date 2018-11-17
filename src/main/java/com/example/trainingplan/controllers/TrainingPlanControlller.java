package com.example.trainingplan.controllers;

import com.example.trainingplan.model.*;
import com.example.trainingplan.service.ExerciseService;
import com.example.trainingplan.service.TrainingService;
import com.example.trainingplan.service.UserService;
import com.example.trainingplan.workout.ChooseExercises;
import com.example.trainingplan.workout.TrainingGoal;
import com.example.trainingplan.workout.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class TrainingPlanControlller {

    @Autowired
    UserService userService;

    @Autowired
    TrainingService trainingService;

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/createPlan")
    public String createPlan(Model model){
        model.addAttribute("trainingGoal", new TrainingGoal());
        return "create_my_plan";
    }

    @PostMapping("/saveWorkout")
    public String savePlan(@ModelAttribute @Valid Wrapper wrapper, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "redirect:/createPlan";
        }

        trainingService.saveWorkout(wrapper);

        return "index";
    }

    @PostMapping("/chooseExercises")
    public String createPlan(@ModelAttribute TrainingGoal trainingGoal, Model model){

        // Pobranie odpowiedniego schematu treningowego
        String type = trainingService.determineTrainingType(trainingGoal.getFrequency());
        TrainingSchema trainingSchema = trainingService.findFirstSchemaByTypeAndLengthAndGoal(type, trainingGoal.getLength(), trainingGoal.getGoal());

        // tworzenie lista zawierajacej odpowiednie cwiczenia do wyboru oraz sposob ich wykonania
        Wrapper wrapper = new Wrapper();

        for(ExerciseSchema exerciseSchema: trainingSchema.getExerciseSchemas()){

            ExerciseType exerciseType = exerciseService.findFirstSchemaByExerciseNumberAndTrainingNumberAndTrainingSchema(
                    exerciseSchema.getExerciseNumber(),
                    exerciseSchema.getTrainingNumber(),
                    trainingSchema).getExerciseType();

            wrapper.getChooseExercises().add(new ChooseExercises(
                    new ExerciseTraining(exerciseSchema.getExerciseNumber(), exerciseSchema.getTrainingNumber(),exerciseSchema.getSets(), exerciseSchema.getReps(), exerciseSchema.getRest(),
                            exerciseService.findFirstExerciseByExerciseType(exerciseType),
                            new TrainingPlan(type, "", userService.findUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()))),
                    new ArrayList<>(exerciseService.findAllExerciseByExerciseType(exerciseType))));
        }

        model.addAttribute("wrapper", wrapper);

        return "choose_exercise";
    }

}
