package com.example.laboratorio2.service.impl;

import com.example.laboratorio2.domain.entity.Sorcerer;
import com.example.laboratorio2.repository.SorcererRepository;
import com.example.laboratorio2.service.SorcererService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SorcererServiceImpl implements SorcererService {

    private final SorcererRepository sorcererRepository;

    public SorcererServiceImpl(SorcererRepository sorcererRepository) {
        this.sorcererRepository = sorcererRepository;
    }

    @Override
    public Sorcerer save(Sorcerer sorcerer) {
        sorcerer.setId(null);
        return sorcererRepository.save(sorcerer);
    }

    @Override
    public List<Sorcerer> findAll() {
        return sorcererRepository.findAll();
    }

    @Override
    public Sorcerer findById(UUID id) {
        return sorcererRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sorcerer not found with id: " + id));
    }

    @Override
    public Sorcerer update(UUID id, Sorcerer sorcerer) {
        Sorcerer existingSorcerer = findById(id);

        existingSorcerer.setName(sorcerer.getName());
        existingSorcerer.setGrade(sorcerer.getGrade());
        existingSorcerer.setCursedTechnique(sorcerer.getCursedTechnique());
        existingSorcerer.setSchool(sorcerer.getSchool());
        existingSorcerer.setCursedEnergy(sorcerer.getCursedEnergy());
        existingSorcerer.setIsActive(sorcerer.getIsActive());

        return sorcererRepository.save(existingSorcerer);
    }

    @Override
    public void delete(UUID id) {
        Sorcerer sorcerer = findById(id);
        sorcererRepository.delete(sorcerer);
    }

    @Override
    public List<Sorcerer> findBySchool(String school) {
        return sorcererRepository.findBySchoolIgnoreCase(school);
    }

    @Override
    public List<Sorcerer> findByGrade(String grade) {
        return sorcererRepository.findByGradeIgnoreCase(grade);
    }

    @Override
    public List<Sorcerer> findActive() {
        return sorcererRepository.findByIsActiveTrue();
    }
}
