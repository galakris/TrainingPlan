package com.example.trainingplan.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable=false, length = 32)
    private String name;
    //  push|pull
    @Column( nullable=false, length = 32)
    private String type;

    // lowerbody|upperbody|core
    @Column( nullable=false, length = 32)
    private String muscleGroup;

    // chest, back, biceps,
    @Column( nullable=false, length = 32)
    private String muscle;

    // main|accessory
    @Column( nullable=false, length = 32)
    private String category;

    // how to do
    private String descryption;

    @OneToMany(mappedBy = "exercise",fetch = FetchType.EAGER)
    private List<ExerciseTraining> exerciseTrainings;

    public Exercise() {
    }

    public Exercise(String name, String type, String muscleGroup, String muscle, String category, String descryption) {
        this.name = name;
        this.type = type;
        this.muscleGroup = muscleGroup;
        this.muscle = muscle;
        this.category = category;
        this.descryption = descryption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public List<ExerciseTraining> getExerciseTrainings() {
        return exerciseTrainings;
    }

    public void setExerciseTrainings(List<ExerciseTraining> exerciseTrainings) {
        this.exerciseTrainings = exerciseTrainings;
    }

}
