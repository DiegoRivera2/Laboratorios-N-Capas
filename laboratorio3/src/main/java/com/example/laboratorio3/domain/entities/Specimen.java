package com.example.laboratorio3.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "specimen")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specimen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "danger_level", nullable = false)
    private Integer dangerLevel;

    @Column(name = "is_friendly", nullable = false)
    private Boolean isFriendly;
}