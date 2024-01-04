package com.csie.examapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.csie.examapp.entities.TestEntity;
import com.csie.examapp.entities.TeacherEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    @Query("SELECT t FROM TestEntity t where t.teacher = :teacher")
    List<TestEntity> findByTeacher(@Param("teacher") TeacherEntity teacher);
}
