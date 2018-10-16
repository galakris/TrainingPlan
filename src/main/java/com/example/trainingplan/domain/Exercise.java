package com.example.trainingplan.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable=false, length = 32)
    private String name;
    @Column( nullable=false, length = 32)
    private String type;
    @Column( nullable=false, length = 32)
    private String muscleGroup;
    @Column( nullable=false, length = 32)
    private String muscle;
    @Column( nullable=false, length = 32)
    private String category;
    private String descryption;
    @OneToMany(mappedBy = "exercise")
    private List<ExerciseTraining> exerciseTrainings;

    public Exercise() {
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
