package com.example.trainingplan.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // FBW/Split
    private String type;
    private String name;
    @OneToMany(mappedBy = "trainingPlan",fetch = FetchType.EAGER)
    private List <TrainingDay> trainingDay;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public TrainingPlan() {
    }

    public TrainingPlan(String type, String name, User user) {
        this.type = type;
        this.name = name;
        this.user = user;
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

    public List<TrainingDay> getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(List<TrainingDay> trainingDay) {
        this.trainingDay = trainingDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
