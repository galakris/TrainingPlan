package com.example.trainingplan;

import com.example.trainingplan.model.*;
import com.example.trainingplan.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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
    TrainingDayRepository trainingDayRepository;

    @Autowired
    ExerciseTrainingRepository exerciseTrainingRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DateTestRepository dateTestRepository;

    @Override
    public void run(String... args) throws Exception {


        dateTestRepository.save(
                new DateTest(
                        new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-17"),
                        new SimpleDateFormat("HH:mm").parse("09:15")
                ));

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
    }
}
