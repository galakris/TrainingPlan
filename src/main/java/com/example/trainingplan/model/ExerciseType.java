package com.example.trainingplan.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExerciseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // main|accessory
    @Column( nullable=false, length = 32)
    private String category;

    //  push|pull
    @Column( nullable=false, length = 32)
    private String type;

    // lowerbody|upperbody|core
    @Column( nullable=false, length = 32)
    private String muscleGroup;

    @OneToMany(mappedBy = "exerciseType")
    private List<ExerciseSchema> exerciseSchemas;

    @OneToMany(mappedBy = "exerciseType")
    private List<Exercise> exercises;

    public ExerciseType() {
    }

    public ExerciseType(String category, String type, String muscleGroup) {
        this.category = category;
        this.type = type;
        this.muscleGroup = muscleGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public List<ExerciseSchema> getExerciseSchemas() {
        return exerciseSchemas;
    }

    public void setExerciseSchemas(List<ExerciseSchema> exerciseSchemas) {
        this.exerciseSchemas = exerciseSchemas;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }


}
