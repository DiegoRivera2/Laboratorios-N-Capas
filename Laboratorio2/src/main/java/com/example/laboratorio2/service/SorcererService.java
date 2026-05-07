package com.example.laboratorio2.service;

import com.example.laboratorio2.domain.entity.Sorcerer;

import java.util.List;
import java.util.UUID;

public interface SorcererService {
    Sorcerer save(Sorcerer sorcerer);
    List<Sorcerer> findAll();
    Sorcerer findById(UUID id);
    Sorcerer update(UUID id, Sorcerer sorcerer);
    void delete(UUID id);
    List<Sorcerer> findBySchool(String school);
    List<Sorcerer> findByGrade(String grade);
    List<Sorcerer> findActive();
}
