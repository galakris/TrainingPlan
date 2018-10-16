package com.example.trainingplan.repository;

import com.example.trainingplan.model.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {
}
