package com.csie.examapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.csie.examapp.entities.TeacherEntity;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {
    @Query("SELECT t FROM TeacherEntity t where t.eMail = :eMail")
    List<TeacherEntity> findByEMail(@Param("eMail") String eMail);
}
