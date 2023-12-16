package com.csie.examapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csie.examapp.entities.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
