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

    // chest, back, biceps,
    //@Column( nullable=false, length = 32)
    private String muscle;

    // polish descryption
    private String descryption;

    // how to do
    private String instruction;

    // street workout available
    private boolean streetWorkout;

    @OneToMany(mappedBy = "exercise",fetch = FetchType.EAGER)
    private List<ExerciseTraining> exerciseTrainings;

    @ManyToOne
    @JoinColumn(name = "exercise_type_id")
    private ExerciseType exerciseType;

    public Exercise() {
    }


    public Exercise(String name, String descryption, String muscle, String instruction, boolean streetWorkout, ExerciseType exerciseType) {
        this.name = name;
        this.muscle = muscle;
        this.descryption = descryption;
        this.instruction = instruction;
        this.streetWorkout = streetWorkout;
        this.exerciseType = exerciseType;
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

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public boolean isStreetWorkout() {
        return streetWorkout;
    }

    public void setStreetWorkout(boolean streetWorkout) {
        this.streetWorkout = streetWorkout;
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

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
