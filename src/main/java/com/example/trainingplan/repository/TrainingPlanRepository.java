package com.example.trainingplan.repository;

import com.example.trainingplan.model.TrainingPlan;
import com.example.trainingplan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {

    List<TrainingPlan> findAllByUser(User user);
}
