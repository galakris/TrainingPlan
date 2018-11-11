package com.example.trainingplan.workout;

import org.springframework.stereotype.Component;

@Component
public class TrainingGoal {

    // dlugosc treningu (min), 30/60
    private int length;
    // liczba treningow  w tygodniu
    private int frequency;
    // cel treningoowy - siła/masa/odchudzanie
    private String goal;
    // siłownia / plener
    private String place;

    public TrainingGoal() {
    }

    public TrainingGoal(int length, int frequency, String goal, String place) {
        this.length = length;
        this.frequency = frequency;
        this.goal = goal;
        this.place = place;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "TrainingGoal{" +
                "length=" + length +
                ", frequency=" + frequency +
                ", goal='" + goal + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
