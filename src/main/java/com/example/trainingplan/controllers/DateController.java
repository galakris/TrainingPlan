package com.example.trainingplan.controllers;

import com.example.trainingplan.model.DateTest;
import com.example.trainingplan.repository.DateTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DateController {

    @Autowired
    DateTestRepository dateTestRepository;

    @GetMapping("/date")
    public String getDate(Model model){
        List<DateTest> dateTests = dateTestRepository.findAll();
        model.addAttribute("dates", dateTests);
        return "date";
    }

    @PostMapping("/addDate")
    public String addDate(@ModelAttribute DateTest dateTest){
        dateTestRepository.save(dateTest);
        return "redirect:/date";
    }

    @GetMapping("/addDate")
    public String addDate(Model model){
        model.addAttribute("date", new DateTest());
        return "add_date";
    }

}
