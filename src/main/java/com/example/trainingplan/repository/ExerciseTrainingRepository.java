package com.example.trainingplan.repository;

import com.example.trainingplan.model.ExerciseTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseTrainingRepository extends JpaRepository<ExerciseTraining, Long> {
}
