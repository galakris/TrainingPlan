package com.example.trainingplan.workout;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class Wrapper {
    ArrayList<ChooseExercises> chooseExercises;

    @Size(max = 32)
    @NotEmpty
    String name;

    public Wrapper() {
        chooseExercises = new ArrayList<>();
    }

    public ArrayList<ChooseExercises> getChooseExercises() {
        return chooseExercises;
    }

    public void setChooseExercises(ArrayList<ChooseExercises> chooseExercises) {
        this.chooseExercises = chooseExercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
