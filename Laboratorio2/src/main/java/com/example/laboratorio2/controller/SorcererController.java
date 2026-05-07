package com.example.laboratorio2.controller;

import com.example.laboratorio2.domain.entity.Sorcerer;
import com.example.laboratorio2.service.SorcererService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sorcerers")
public class SorcererController {

    private final SorcererService sorcererService;

    public SorcererController(SorcererService sorcererService) {
        this.sorcererService = sorcererService;
    }

    @PostMapping
    public ResponseEntity<Sorcerer> save(@RequestBody Sorcerer sorcerer) {
        return new ResponseEntity<>(sorcererService.save(sorcerer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sorcerer>> findAll() {
        return ResponseEntity.ok(sorcererService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sorcerer> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(sorcererService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sorcerer> update(@PathVariable UUID id, @RequestBody Sorcerer sorcerer) {
        return ResponseEntity.ok(sorcererService.update(id, sorcerer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        sorcererService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/school/{school}")
    public ResponseEntity<List<Sorcerer>> findBySchool(@PathVariable String school) {
        return ResponseEntity.ok(sorcererService.findBySchool(school));
    }

    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Sorcerer>> findByGrade(@PathVariable String grade) {
        return ResponseEntity.ok(sorcererService.findByGrade(grade));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Sorcerer>> findActive() {
        return ResponseEntity.ok(sorcererService.findActive());
    }
}
