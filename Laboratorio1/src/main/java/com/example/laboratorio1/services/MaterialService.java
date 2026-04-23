package com.example.laboratorio1.services;

import com.example.laboratorio1.domain.model.Material;
import com.example.laboratorio1.repositories.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> obtenerTodos() {
        return materialRepository.obtenerTodos();
    }

    public List<Material> obtenerTodosOrdenadosPorPrecioDesc() {
        return materialRepository.obtenerTodos()
                .stream()
                .sorted(Comparator.comparingInt(Material::getPrecioVentaEnRupias).reversed())
                .toList();
    }

    public Material obtenerMaterialMasCaro() {
        return materialRepository.obtenerTodos()
                .stream()
                .max(Comparator.comparingInt(Material::getPrecioVentaEnRupias))
                .orElse(null);
    }

    public List<Material> obtenerLegendarios() {
        return materialRepository.obtenerTodos()
                .stream()
                .filter(material -> "Legendario".equalsIgnoreCase(material.getGradoRareza()))
                .toList();
    }

    public List<String> obtenerUbicacionesSinRepetir() {
        return materialRepository.obtenerTodos()
                .stream()
                .map(Material::getUbicacionPrincipal)
                .distinct()
                .toList();
    }
}
