package com.example.trainingplan.repository;

import com.example.trainingplan.model.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Long> {

    ExerciseType findFirstByCategoryAndTypeContainingAndMuscleGroup(String category, String type, String muscleGroup);
}
