package com.csie.examapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csie.examapp.entities.TestResultEntity;

@Repository
public interface TestResultRepository extends JpaRepository<TestResultEntity, Integer> {

}
