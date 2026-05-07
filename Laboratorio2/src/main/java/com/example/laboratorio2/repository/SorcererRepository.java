package com.example.laboratorio2.repository;

import com.example.laboratorio2.domain.entity.Sorcerer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SorcererRepository extends JpaRepository<Sorcerer, UUID> {
    List<Sorcerer> findBySchoolIgnoreCase(String school);
    List<Sorcerer> findByGradeIgnoreCase(String grade);
    List<Sorcerer> findByIsActiveTrue();
}