package com.example.trainingplan.model;

import javax.persistence.*;

@Entity
public class ExerciseTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Numer ciwczenie w dniu treningowym np. 3
    private int number;
    // liczba serii
    private int sets;
    // liczba powtorzen
    private int reps;
    // dlugosc przerwy miedzy seriami (s)
    private int rest;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "training_day_id")
    private TrainingDay trainingDay;

    public ExerciseTraining() {
    }

    public ExerciseTraining(int number, int sets, int reps, int rest, Exercise exercise, TrainingDay trainingDay) {
        this.number = number;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.exercise = exercise;
        this.trainingDay = trainingDay;
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
