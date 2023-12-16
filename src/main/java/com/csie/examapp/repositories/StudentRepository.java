package com.csie.examapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.csie.examapp.entities.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query("SELECT s FROM StudentEntity s where s.eMail = :eMail")
    List<StudentEntity> findByEMail(@Param("eMail") String eMail);
}
