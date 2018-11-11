package com.example.trainingplan.repository;

import com.example.trainingplan.model.ExerciseSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseSchemaRepository extends JpaRepository<ExerciseSchema, Long> {
}
