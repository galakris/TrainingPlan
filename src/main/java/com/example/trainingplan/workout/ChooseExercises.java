package com.example.trainingplan.workout;

import com.example.trainingplan.model.Exercise;
import com.example.trainingplan.model.ExerciseTraining;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public class ChooseExercises {
    private ExerciseTraining exerciseTraining;
    private ArrayList<Exercise> exercises;

    public ChooseExercises() {
    }

    public ChooseExercises(ExerciseTraining exerciseTraining, ArrayList<Exercise> exercises) {
        this.exerciseTraining = exerciseTraining;
        this.exercises = exercises;
    }

    public ExerciseTraining getExerciseTraining() {
        return exerciseTraining;
    }

    public void setExerciseTraining(ExerciseTraining exerciseTraining) {
        this.exerciseTraining = exerciseTraining;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
