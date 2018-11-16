package com.example.trainingplan.workout;

import java.util.ArrayList;

public class Wrapper {
    ArrayList<ChooseExercises> chooseExercises;

    public Wrapper() {
        chooseExercises = new ArrayList<>();
    }

    public ArrayList<ChooseExercises> getChooseExercises() {
        return chooseExercises;
    }

    public void setChooseExercises(ArrayList<ChooseExercises> chooseExercises) {
        this.chooseExercises = chooseExercises;
    }
}
