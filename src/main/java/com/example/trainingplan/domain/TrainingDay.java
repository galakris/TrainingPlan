package com.example.trainingplan.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;
    @OneToMany(mappedBy = "trainingDay")
    private List<ExerciseTraining> exerciseTraining;


    public TrainingDay() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public List<ExerciseTraining> getExerciseTraining() {
        return exerciseTraining;
    }

    public void setExerciseTraining(List<ExerciseTraining> exerciseTraining) {
        this.exerciseTraining = exerciseTraining;
    }
}
