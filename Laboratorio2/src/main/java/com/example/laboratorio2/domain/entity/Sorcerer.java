package com.example.laboratorio2.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "sorcerers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sorcerer {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    private String grade;
    private String cursedTechnique;
    private String school;
    private Double cursedEnergy;
    private Boolean isActive;
}
