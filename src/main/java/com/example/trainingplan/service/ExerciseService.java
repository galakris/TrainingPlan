package com.example.trainingplan.service;

import com.example.trainingplan.model.Exercise;
import com.example.trainingplan.model.ExerciseSchema;
import com.example.trainingplan.model.ExerciseType;
import com.example.trainingplan.model.TrainingSchema;
import com.example.trainingplan.repository.ExerciseRepository;
import com.example.trainingplan.repository.ExerciseSchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    
    @Autowired
    ExerciseSchemaRepository exerciseSchemaRepository;
    
    @Autowired
    ExerciseRepository exerciseRepository;
    
    public ExerciseSchema findFirstSchemaByExerciseNumberAndTrainingNumberAndTrainingSchema(int exerciseNumber, String trainingNumber, TrainingSchema trainingSchema) {
        return exerciseSchemaRepository.findFirstByExerciseNumberAndTrainingNumberAndTrainingSchema( exerciseNumber, trainingNumber, trainingSchema);
    }

    public Exercise findFirstExerciseByExerciseType(ExerciseType exerciseType) {
        return exerciseRepository.findFirstByExerciseType(exerciseType);
    }

    public List<Exercise> findAllExerciseByExerciseType(ExerciseType exerciseType) {
        return exerciseRepository.findAllByExerciseType(exerciseType);
    }

    public List<Exercise> findAllExercises() {
        return exerciseRepository.findAll();
    }
}
