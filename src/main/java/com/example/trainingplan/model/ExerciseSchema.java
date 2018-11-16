package com.example.trainingplan.model;

import javax.persistence.*;

@Entity
public class ExerciseSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // A/B
    @Column(length = 2)
    private int trainingNumber;

    private int exerciseNumber;

    // liczba serii
    private int sets;
    // liczba powtorzen
    private int reps;
    // dlugosc przerwy miedzy seriami (s)
    private int rest;

    @ManyToOne
    @JoinColumn(name = "training_schema_id")
    private TrainingSchema trainingSchema;

    @ManyToOne
    @JoinColumn(name = "exercise_type_id")
    private ExerciseType exerciseType;

    public ExerciseSchema() {
    }

    public ExerciseSchema(int trainingNumber, int exerciseNumber, int sets, int reps, int rest, TrainingSchema trainingSchema, ExerciseType exerciseType) {
        this.trainingNumber = trainingNumber;
        this.exerciseNumber = exerciseNumber;
        this.sets = sets;
        this.reps = reps;
        this.rest = rest;
        this.trainingSchema = trainingSchema;
        this.exerciseType = exerciseType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTrainingNumber() {
        return trainingNumber;
    }

    public void setTrainingNumber(int trainingNumber) {
        this.trainingNumber = trainingNumber;
    }

    public int getExerciseNumber() {
        return exerciseNumber;
    }

    public void setExerciseNumber(int exerciseNumber) {
        this.exerciseNumber = exerciseNumber;
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

    public TrainingSchema getTrainingSchema() {
        return trainingSchema;
    }

    public void setTrainingSchema(TrainingSchema trainingSchema) {
        this.trainingSchema = trainingSchema;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    @Override
    public String toString() {
        return "ExerciseSchema{" +
                "id=" + id +
                ", trainingNumber=" + trainingNumber +
                ", exerciseNumber=" + exerciseNumber +
                ", sets=" + sets +
                ", reps=" + reps +
                ", rest=" + rest +
                '}';
    }
}
