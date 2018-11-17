package com.example.trainingplan.repository;

import com.example.trainingplan.model.ExerciseSchema;
import com.example.trainingplan.model.TrainingSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseSchemaRepository extends JpaRepository<ExerciseSchema, Long> {

    ExerciseSchema findFirstByExerciseNumberAndTrainingNumberAndTrainingSchema(int exerciseNumber, String trainingNumber, TrainingSchema trainingSchema);
}
