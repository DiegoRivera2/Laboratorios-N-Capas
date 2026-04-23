package com.example.laboratorio1.repositories;

import com.example.laboratorio1.common.ListaMateriales;
import com.example.laboratorio1.domain.model.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialRepository {

    private final ListaMateriales listaMateriales;

    public MaterialRepository(ListaMateriales listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public List<Material> obtenerTodos() {
        return listaMateriales.obtenerMateriales();
    }
}
