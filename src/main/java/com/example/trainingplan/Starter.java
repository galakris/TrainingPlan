package com.example.trainingplan;

import com.example.trainingplan.model.*;
import com.example.trainingplan.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TrainingPlanRepository trainingPlanRepository;

    @Autowired
    ExerciseTrainingRepository exerciseTrainingRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ExerciseSchemaRepository exerciseSchemaRepository;

    @Autowired
    ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    TrainingSchemaRepository trainingSchemaRepository;

    @Override
    public void run(String... args) throws Exception {

        // dodanie schematów treningowych
        Stream.of(
                new TrainingSchema("FBW",  30 , "mass"),
                new TrainingSchema("FBW",  30 , "strength"),
                new TrainingSchema("FBW",  30 , "silm"),
                new TrainingSchema("FBW",  60 , "mass"),
                new TrainingSchema("FBW",  60 , "strength"),
                new TrainingSchema("FBW",  60 , "silm"),
                new TrainingSchema("FBW",  90 , "mass"),
                new TrainingSchema("FBW",  90 , "strength"),
                new TrainingSchema("FBW",  90 , "silm"),
                new TrainingSchema("Split",  30 , "mass"),
                new TrainingSchema("Split",  30 , "strength"),
                new TrainingSchema("Split",  30 , "silm"),
                new TrainingSchema("Split",  60 , "mass"),
                new TrainingSchema("Split",  60 , "strength"),
                new TrainingSchema("Split",  60 , "silm"),
                new TrainingSchema("Split",  90 , "mass"),
                new TrainingSchema("Split",  90 , "strength"),
                new TrainingSchema("Split",  90 , "silm")
        ).forEach(trainingSchemaRepository::save);

        // dodanie typow cwiczen
        Stream.of(
                new ExerciseType("main", "push" , "lowerbody"),
                new ExerciseType("main", "pull" , "lowerbody"),
                new ExerciseType("main", "push|horizontal push" , "upperbody"),
                new ExerciseType("main", "pull|horizontal pull" , "upperbody"),
                new ExerciseType("main", "push|vertical push" , "upperbody"),
                new ExerciseType("main", "pull|vertical pull" , "upperbody"),
                new ExerciseType("accessor", "core" , "abs"),
                new ExerciseType("accessor", "push" , "lowerbody"),
                new ExerciseType("accessor", "pull" , "lowerbody"),
                new ExerciseType("accessor", "push" , "upperbody"),
                new ExerciseType("accessor", "pull" , "upperbody")
        ).forEach(exerciseTypeRepository::save);



        // Dodanie schematow cwiczeniowych
        Stream.of(
                new ExerciseSchema("A", 1, 3, 8, 60,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "push", "lowerbody")),
                new ExerciseSchema("A", 2, 3, 8, 60,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical push", "upperbody")),
                new ExerciseSchema("A", 3, 3, 8, 60,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical pull", "upperbody")),
                new ExerciseSchema("A", 4, 3, 30, 30,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "core" , "abs")),
                new ExerciseSchema("B", 1, 3, 8, 60,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "pull", "lowerbody")),
                new ExerciseSchema("B", 2, 3, 8, 60,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal push", "upperbody")),
                new ExerciseSchema("B", 3, 3, 8, 60,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal pull", "upperbody")),
                new ExerciseSchema("B", 4, 3, 30, 30,
                        trainingSchemaRepository.findFirstByTypeAndLengthAndGoal("FBW", 30, "mass"),
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "core" , "abs"))
        ).forEach(exerciseSchemaRepository::save);

        // dodanie cwiczen do bazy danych
        Stream.of(
                new Exercise("Przysiad przedni", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, czworogłowe uda", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "push", "lowerbody")),
                new Exercise("Przysiad ze sztangą", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, czworogłowe uda", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "push", "lowerbody")),
                new Exercise("Przysiad bułgarski", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, czworogłowe uda", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "push", "lowerbody")),
                new Exercise("Martwy ciąg klasyczny", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, dwugłowe uda, prostownik brzbietu", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "pull", "lowerbody")),
                new Exercise("Martwy ciąg sumo", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, dwugłowe uda, prostownik brzbietu", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "pull", "lowerbody")),
                new Exercise("Wyprosty bioder jednonóż", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, prostownik brzbietu", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "pull", "lowerbody")),
                new Exercise("Wykroki", "Ćwiczenie kształtujące siłę dolnej części ciała", "Pośladki, czworogłowe uda", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "push", "lowerbody")),
                new Exercise("Podciąganie", "Ćwiczenie kształtujące siłę  pleców", "Plecy, najszersze grzbietu, czworoboczny, biceps", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical pull" , "upperbody")),
                new Exercise("Wiosłowanie sztangą", "Ćwiczenie kształtujące siłę pleców", "Plecy, najszersze grzbietu, czworoboczny, biceps", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal pull", "upperbody")),
                new Exercise("Wiosłowanie TRX", "Ćwiczenie kształtujące siłę pleców", "Plecy, najszersze grzbietu, czworoboczny, biceps", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal pull", "upperbody")),
                new Exercise("Wiosłowanie hantlem", "Ćwiczenie kształtujące siłę pleców", "Plecy, najszersze grzbietu, czworoboczny, biceps", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal pull", "upperbody")),
                new Exercise("Wyciskanie żołnierskie", "Ćwiczenie kształtujące siłę obręczy barkowej", "Barki, klatka piersiowa, triceps", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical push", "upperbody")),
                new Exercise("Pompka szczupak", "Ćwiczenie kształtujące siłę obręczy barkowej", "Barki, klatka piersiowa, triceps", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical push", "upperbody")),
                new Exercise("Wyciskanie hantli stojąc", "Ćwiczenie kształtujące siłę obręczy barkowej", "Barki, klatka piersiowa, triceps", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical push", "upperbody")),
                new Exercise("Wysiskanie sztangi na ławce", "Ćwiczenie kształtujące siłę klatki piersiowej", "Barki, klatka piersiowa, triceps", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal push", "upperbody")),
                new Exercise("Pompki", "Ćwiczenie kształtujące siłę klatki piersiowej", "Barki, klatka piersiowa, triceps", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal push", "upperbody")),
                new Exercise("Wysiskanie hantli na ławce", "Ćwiczenie kształtujące siłę klatki piersiowej", "Barki, klatka piersiowa, triceps", "", false,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal push", "upperbody")),
                new Exercise("Deska", "Ćwiczenie kształtujące siłę mieśni brzucha", "Brzuch", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "core" , "abs")),
                new Exercise("Deska bokiem", "Ćwiczenie kształtujące siłę mieśni brzucha", "Barki, klatka piersiowa, triceps", "", true,
                        exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "core" , "abs"))
        ).forEach(exerciseRepository::save);
        // dodanie uzytkownikow
        Stream.of(
                new User("galakris", passwordEncoder.encode("galakris"), "Krzysztof" , "Gałuszka", "galakris@wp.pl" ),
                new User("andrzejek", passwordEncoder.encode("12345"), "Andrzej" , "Wronek", "wronek@wp.pl" )
        ).forEach(userRepository::save);

        //dodanie planow treningowych
        Stream.of(
                new TrainingPlan("FBW", "Hard Mass!", userRepository.findById(1L).get()),
                new TrainingPlan("Split", "Paprykowy koks", userRepository.findById(1L).get())
        ).forEach(trainingPlanRepository::save);

        // pobranie ID dodawanego planu treningowego
        TrainingPlan trainingPlan = trainingPlanRepository.save(new TrainingPlan("FBW", "Wielka Klata", userRepository.findById(2L).get()));
        System.out.println("ID treningu \"Wielka klata\":" + trainingPlan.getId());

//        //dodanie dni treningowych
//        List<TrainingDay> trainingDays = new ArrayList<>();
//        trainingDays.add(new TrainingDay("Trening A", trainingPlan));
//        trainingDays.add(new TrainingDay("Trening B", trainingPlan));
//
//        trainingDays.stream().forEach(trainingDayRepository::save);
//
//        // Podbranie dodanego planu treningowego z bazy i wyświetlnie informacji o dniach treningowych
//        trainingPlan = trainingPlanRepository.findById(3L).get();
//        trainingPlan.getTrainingDay().forEach(trainingDay -> System.out.println("ID: " + trainingDay.getId() + ", nazwa: " + trainingDay.getName()));

        // Dodanie ExerciseTraining - przypisanie ćwieczeń do dni treningowych
        Stream.of(
                new ExerciseTraining(1, "Trening A", 3, 8, 60,
                        exerciseRepository.findFirstByName("Przysiad ze sztangą"),
                        trainingPlan),
                new ExerciseTraining(2, "Trening A", 3, 8, 60,
                        exerciseRepository.findFirstByExerciseType(exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical push", "upperbody")) ,
                        trainingPlan),
                new ExerciseTraining(2, "Trening A", 3, 8, 60,
                        exerciseRepository.findFirstByExerciseType(exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "vertical pull", "upperbody")) ,
                        trainingPlan),
                new ExerciseTraining(2, "Trening A", 3, 30, 30,
                        exerciseRepository.findFirstByExerciseType(exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "core", "abs")) ,
                        trainingPlan),
                new ExerciseTraining(1, "Trening B", 3, 8, 60,
                        exerciseRepository.findFirstByName("Martwy ciąg klasyczny"),
                        trainingPlan),
                new ExerciseTraining(2, "Trening B", 3, 8, 60,
                        exerciseRepository.findFirstByExerciseType(exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal push", "upperbody")) ,
                        trainingPlan),
                new ExerciseTraining(2, "Trening B", 3, 8, 60,
                        exerciseRepository.findFirstByExerciseType(exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("main", "horizontal pull", "upperbody")) ,
                        trainingPlan),
                new ExerciseTraining(2, "Trening B", 3, 30, 30,
                        exerciseRepository.findFirstByExerciseType(exerciseTypeRepository.findFirstByCategoryAndTypeContainingAndMuscleGroup("accessor", "core", "abs")) ,
                        trainingPlan)
        ).forEach(exerciseTrainingRepository::save);

/*
        // dodanie cwiczen do bazy danych
        Stream.of(
                new Exercise("Przysiad", "push", "lowerbody", "thigh|qlute|legs", "main", "Ćwiczenie kształtujące siłę dolnej części ciała",""),
                new Exercise("Martwy ciąg", "pull", "lowerbody", "thigh|qlute|legs", "main", "Ćwiczenie kształtujące siłę dolnej części ciała",""),
                new Exercise("Wykroki", "push", "lowerbody", "quad|qlute|legs", "accessor", "Ćwiczenie kształtujące siłę dolnej części ciała",""),
                new Exercise("Podciąganie", "pull", "upperbody", "lats|back", "main", "Ćwiczenie kształtujące siłę pleców i ramion",""),
                new Exercise("Wiosłowanie", "pull", "upperbody", "lats|back", "main", "Ćwiczenie kształtujące siłę pleców.",""),
                new Exercise("Wyciskanie Żołnierskie", "push", "upperbody", "shoulder", "main", "Ćwiczenie kształtujące siłę barków. ",""),
                new Exercise("Wyciskanie hantli na łąwce", "push", "upperbody", "chest", "main", "Ćwiczenie kształtujące siłę klatki piersiowej",""),
                new Exercise("Deska", "", "core", "abs", "accessor", "Ćwiczenie kształtujące siłę brzucha","")
        ).forEach(exerciseRepository::save);
        // dodanie uzytkownikow
        Stream.of(
                new User("galakris", passwordEncoder.encode("galakris"), "Krzysztof" , "Gałuszka", "galakris@wp.pl" ),
                new User("andrzejek", passwordEncoder.encode("12345"), "Andrzej" , "Wronek", "wronek@wp.pl" )
        ).forEach(userRepository::save);

        //dodanie planow treningowych
        Stream.of(
                new TrainingPlan("FBW", "Hard Mass!", userRepository.findById(1L).get()),
                new TrainingPlan("Split", "Paprykowy koks", userRepository.findById(1L).get())
        ).forEach(trainingPlanRepository::save);

        // pobranie ID dodawanego planu treningowego
        TrainingPlan trainingPlan = trainingPlanRepository.save(new TrainingPlan("FBW", "Wielka Klata", userRepository.findById(2L).get()));
        System.out.println("ID treningu \"Wielka klata\":" + trainingPlan.getId());

        //dodanie dni treningowych
        List<TrainingDay> trainingDays = new ArrayList<>();
        trainingDays.add(new TrainingDay("Trening A", trainingPlan));
        trainingDays.add(new TrainingDay("Trening B", trainingPlan));

        trainingDays.stream().forEach(trainingDayRepository::save);

        // Podbranie dodanego planu treningowego z bazy i wyświetlnie informacji o dniach treningowych
        trainingPlan = trainingPlanRepository.findById(3L).get();
        trainingPlan.getTrainingDay().forEach(trainingDay -> System.out.println("ID: " + trainingDay.getId() + ", nazwa: " + trainingDay.getName()));

        // Dodanie ExerciseTraining - przypisanie ćwieczeń do dni treningowych
        Stream.of(
                new ExerciseTraining(1, 3, 10, 60, exerciseRepository.findFirstByName("Przysiad"),trainingDays.get(0)),
                new ExerciseTraining(2, 3, 10, 60, exerciseRepository.findFirstByMuscleGroupAndType("upperbody", "push"),trainingDays.get(0)),
                new ExerciseTraining(3, 3, 10, 60, exerciseRepository.findFirstByMuscleGroupAndType("upperbody", "pull"),trainingDays.get(0)),
                new ExerciseTraining(1, 3, 10, 60, exerciseRepository.findFirstByName("Martwy ciąg"),trainingDays.get(1)),
                new ExerciseTraining(2, 3, 10, 60, exerciseRepository.findFirstByMuscleGroupAndType("upperbody", "push"),trainingDays.get(1)),
                new ExerciseTraining(3, 3, 10, 60, exerciseRepository.findFirstByMuscleGroupAndType("upperbody", "pull"),trainingDays.get(1))
        ).forEach(exerciseTrainingRepository::save);
        */

    }

}
