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
    // nazwa dnia treningwego
    @Column(length = 4)
    private String trainingDayNumber;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;

    public ExerciseTraining() {
    }

    public ExerciseTraining(int number, String trainingDayNumber ,int sets, int reps, int rest, Exercise exercise, TrainingPlan trainingPlan) {
        this.number = number;
        this.trainingDayNumber = trainingDayNumber;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.exercise = exercise;
        this.trainingPlan = trainingPlan;
    }

    public ExerciseTraining(int number, int sets, int reps, int rest, Exercise exercise) {
        this.number = number;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.exercise = exercise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrainingDayNumber() {
        return trainingDayNumber;
    }

    public void setTrainingDayNumber(String trainingDayNumber) {
        this.trainingDayNumber = trainingDayNumber;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    @Override
    public String toString() {
        return "ExerciseTraining{" +
                "id=" + id +
                ", number=" + number +
                ", sets=" + sets +
                ", reps=" + reps +
                ", rest=" + rest +
                ", trainingDayNumber='" + trainingDayNumber + '\'' +
                ", exercise=" + exercise +
                ", trainingPlan=" + trainingPlan +
                '}';
    }
}
