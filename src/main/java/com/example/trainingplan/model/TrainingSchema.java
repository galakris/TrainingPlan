package com.example.trainingplan.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    // dlugosc w minutach
    private int length;
    // cel mass/strength/fit
    private String goal;

    @OneToMany(mappedBy = "trainingSchema",fetch = FetchType.EAGER)
    private List<ExerciseSchema> exerciseSchemas;

    public TrainingSchema() {
    }

    public TrainingSchema(String type, int length, String goal) {
        this.type = type;
        this.length = length;
        this.goal = goal;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<ExerciseSchema> getExerciseSchemas() {
        return exerciseSchemas;
    }

    public void setExerciseSchemas(List<ExerciseSchema> exerciseSchemas) {
        this.exerciseSchemas = exerciseSchemas;
    }


}
