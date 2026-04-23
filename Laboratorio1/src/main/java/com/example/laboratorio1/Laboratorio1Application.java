package com.example.laboratorio1;

import com.example.laboratorio1.domain.model.Material;
import com.example.laboratorio1.services.MaterialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Laboratorio1Application {

    public static void main(String[] args) {
        SpringApplication.run(Laboratorio1Application.class, args);
    }

    @Bean
    public CommandLineRunner run(MaterialService materialService) {
        return args -> {
            System.out.println("=== INICIANDO APP ===");

            System.out.println("\n=== CATÁLOGO COMPLETO ===");
            materialService.obtenerTodos().forEach(material ->
                    System.out.println("[HYRULE-DB] Nombre: " + material.getNombre()
                            + " | Categoría: " + material.getCategoria()
                            + " | Precio: " + material.getPrecioVentaEnRupias() + " Rupias")
            );

            System.out.println("\n=== ORDENADOS DE MAYOR A MENOR PRECIO ===");
            materialService.obtenerTodosOrdenadosPorPrecioDesc().forEach(material ->
                    System.out.println(material.getNombre() + " - " + material.getPrecioVentaEnRupias() + " Rupias")
            );

            System.out.println("\n=== MATERIAL MÁS CARO ===");
            Material masCaro = materialService.obtenerMaterialMasCaro();
            if (masCaro != null) {
                System.out.println(masCaro.getNombre() + " - " + masCaro.getPrecioVentaEnRupias() + " Rupias");
            }

            System.out.println("\n=== MATERIALES LEGENDARIOS ===");
            materialService.obtenerLegendarios().forEach(material ->
                    System.out.println(material.getNombre() + " - " + material.getGradoRareza())
            );

            System.out.println("\n=== UBICACIONES SIN REPETIR ===");
            materialService.obtenerUbicacionesSinRepetir().forEach(System.out::println);
        };
    }
}
