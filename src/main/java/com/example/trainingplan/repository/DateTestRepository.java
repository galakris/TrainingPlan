package com.example.trainingplan.repository;

import com.example.trainingplan.model.DateTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTestRepository extends JpaRepository<DateTest, Long > {
}
