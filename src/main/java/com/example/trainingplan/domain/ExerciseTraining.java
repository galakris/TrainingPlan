package com.example.trainingplan.domain;

import javax.persistence.*;

@Entity
public class ExerciseTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reps;
    private int sets;
    private int rest;
    private int number;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "training_day_id")
    private TrainingDay trainingDay;

    public ExerciseTraining() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Exercise getExcercise() {
        return exercise;
    }

    public void setExcercise(Exercise excercise) {
        this.exercise = excercise;
    }

    public TrainingDay getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(TrainingDay trainingDay) {
        this.trainingDay = trainingDay;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
