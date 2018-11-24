package com.example.trainingplan.service;

import com.example.trainingplan.model.TrainingPlan;
import com.example.trainingplan.model.TrainingSchema;
import com.example.trainingplan.repository.*;
import com.example.trainingplan.workout.ChooseExercises;
import com.example.trainingplan.workout.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    TrainingPlanRepository trainingPlanRepository;

    @Autowired
    ExerciseTrainingRepository exerciseTrainingRepository;

    @Autowired
    TrainingSchemaRepository trainingSchemaRepository;

    @Autowired
    UserRepository userRepository;

    public void saveWorkout(Wrapper wrapper){

        // pobranie wybranych cwiczen z bazy danych
        wrapper = setExercisesFromDB(wrapper);

        // zapisanie danych do tabeli TrainingPlan
        TrainingPlan trainingPlan = wrapper.getChooseExercises().get(0).getExerciseTraining().getTrainingPlan();
        trainingPlan = saveTrainingPlan(trainingPlan);

        // zapisanie danych do tabeli ExerciseTraining
        saveExerciseTraining(wrapper.getChooseExercises(), trainingPlan);
    }

    private Wrapper setExercisesFromDB(Wrapper wrapper) {

        for (ChooseExercises chooseExercises : wrapper.getChooseExercises()) {
            chooseExercises.getExerciseTraining().setExercise(exerciseRepository.findFirstByName(chooseExercises.getExerciseTraining().getExercise().getName()));
            // przypisywanie nazwy do planu
            chooseExercises.getExerciseTraining().getTrainingPlan().setName(wrapper.getName());
        }
        return wrapper;
    }

    private void saveExerciseTraining(ArrayList<ChooseExercises> chooseExercises, TrainingPlan trainingPlan) {
        for (ChooseExercises chooseExercise: chooseExercises){
            chooseExercise.getExerciseTraining().setTrainingPlan(trainingPlan);
            System.out.println(chooseExercise.getExerciseTraining());
            exerciseTrainingRepository.save(chooseExercise.getExerciseTraining());
        }
    }


    public TrainingPlan saveTrainingPlan(TrainingPlan trainingPlan) {
        return trainingPlanRepository.save(trainingPlan);
    }

    public String determineTrainingType(int frequency){
        return (frequency<4) ? "FBW" : "Split";
    }

    public TrainingSchema findFirstSchemaByTypeAndLengthAndGoal(String type, int length, String goal) {
        return trainingSchemaRepository.findFirstByTypeAndLengthAndGoal(type,length,goal);
    }

    public List<TrainingPlan> findAllTrainingPlansByUser(String name) {
        return trainingPlanRepository.findAllByUser(userRepository.findByLogin(name));
    }

    public TrainingPlan getTrainingPlan(Long id) {
        return trainingPlanRepository.findById(id).get();
    }
}
