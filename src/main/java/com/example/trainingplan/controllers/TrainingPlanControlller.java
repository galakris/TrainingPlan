package com.example.trainingplan.controllers;

import com.example.trainingplan.model.*;
import com.example.trainingplan.repository.*;
import com.example.trainingplan.workout.ChooseExercises;
import com.example.trainingplan.workout.TrainingGoal;
import com.example.trainingplan.workout.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    TrainingSchemaRepository trainingSchemaRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    ExerciseSchemaRepository exerciseSchemaRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/createPlan")
    public String createPlan(Model model){
        model.addAttribute("trainingGoal", new TrainingGoal());
        return "create_my_plan";
    }

    @PostMapping("/saveWorkout")
    public String savePlan(@ModelAttribute Wrapper wrapper, Model model){

        for (ChooseExercises chooseExercises : wrapper.getChooseExercises()) {
            chooseExercises.getExerciseTraining().setExercise(exerciseRepository.findFirstByName(chooseExercises.getExerciseTraining().getExercise().getName()));
        }

        return "index";
    }

    @PostMapping("/chooseExercises")
    public String createPlan(@ModelAttribute TrainingGoal trainingGoal, Model model){

        // Pobranie odpowiedniego schematu treningowego
        String type = (trainingGoal.getFrequency() < 4) ? "FBW" : "Split";
        TrainingSchema trainingSchema = trainingSchemaRepository.findFirstByTypeAndLengthAndGoal(type, trainingGoal.getLength(), trainingGoal.getGoal());

        // tworzenie lista zawierajacej odpowiednie cwiczenia do wyboru oraz sposob ich wykonania
        Wrapper wrapper = new Wrapper();

        for(ExerciseSchema exerciseSchema: trainingSchema.getExerciseSchemas()){
            ExerciseType exerciseType = exerciseSchemaRepository.findFirstByExerciseNumberAndTrainingNumberAndTrainingSchema(
                    exerciseSchema.getExerciseNumber(),
                    exerciseSchema.getTrainingNumber(),
                    trainingSchema).getExerciseType();

            wrapper.getChooseExercises().add(new ChooseExercises(
                    new ExerciseTraining(exerciseSchema.getExerciseNumber(), exerciseSchema.getSets(), exerciseSchema.getReps(), exerciseSchema.getRest(),
                            exerciseRepository.findFirstByExerciseType(exerciseType),
                            new TrainingDay(exerciseSchema.getTrainingNumber(), new TrainingPlan(type, "", userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName())))),
                    new ArrayList<>(exerciseRepository.findAllByExerciseType(exerciseType))));
        }

        model.addAttribute("wrapper", wrapper);

        return "choose_exercise";
    }

}
