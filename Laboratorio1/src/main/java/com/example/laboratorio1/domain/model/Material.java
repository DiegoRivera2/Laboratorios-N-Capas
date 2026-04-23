package com.example.laboratorio1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Material {
    private String nombre;
    private String categoria;
    private String efectoAlCocinar;
    private int precioVentaEnRupias;
    private String ubicacionPrincipal;
    private String gradoRareza;
}