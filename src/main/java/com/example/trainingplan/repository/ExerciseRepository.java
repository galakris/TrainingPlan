package com.example.trainingplan.repository;

import com.example.trainingplan.model.Exercise;
import com.example.trainingplan.model.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // pierwsze cwiczenie po nazwie
    Exercise findFirstByName(String name);

    Exercise findFirstByExerciseType(ExerciseType exerciseType);

}
