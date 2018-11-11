package com.example.trainingplan.repository;

import com.example.trainingplan.model.TrainingSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingSchemaRepository extends JpaRepository<TrainingSchema, Long> {
    TrainingSchema findFirstByTypeAndLengthAndAndGoal(String type, int length, String goal);
}
