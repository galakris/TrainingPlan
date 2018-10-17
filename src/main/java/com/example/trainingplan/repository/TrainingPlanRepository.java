package com.example.trainingplan.repository;

import com.example.trainingplan.model.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {
}
