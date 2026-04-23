package com.example.laboratorio1.common;

import com.example.laboratorio1.domain.model.Material;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaMateriales {

    public List<Material> obtenerMateriales() {
        return List.of(
                Material.builder()
                        .nombre("Ámbar Rojo")
                        .categoria("Mineral")
                        .efectoAlCocinar("Defensa")
                        .precioVentaEnRupias(30)
                        .ubicacionPrincipal("Volcán de Eldin")
                        .gradoRareza("Raro")
                        .build(),

                Material.builder()
                        .nombre("Ala de Keese")
                        .categoria("Parte de Monstruo")
                        .efectoAlCocinar("Sigilo")
                        .precioVentaEnRupias(15)
                        .ubicacionPrincipal("Cordillera de Hebra")
                        .gradoRareza("Común")
                        .build(),

                Material.builder()
                        .nombre("Pimienta Ardiente")
                        .categoria("Planta")
                        .efectoAlCocinar("Ataque")
                        .precioVentaEnRupias(10)
                        .ubicacionPrincipal("Cordillera de Hebra")
                        .gradoRareza("Poco Común")
                        .build(),

                Material.builder()
                        .nombre("Diamante")
                        .categoria("Mineral")
                        .efectoAlCocinar("Defensa")
                        .precioVentaEnRupias(500)
                        .ubicacionPrincipal("Volcán de Eldin")
                        .gradoRareza("Legendario")
                        .build(),

                Material.builder()
                        .nombre("Trufa Vivaz")
                        .categoria("Planta")
                        .efectoAlCocinar("Estamina")
                        .precioVentaEnRupias(15)
                        .ubicacionPrincipal("Bosque de Farone")
                        .gradoRareza("Raro")
                        .build(),

                Material.builder()
                        .nombre("Manzana")
                        .categoria("Comida")
                        .efectoAlCocinar("Corazones")
                        .precioVentaEnRupias(3)
                        .ubicacionPrincipal("Bosque de Farone")
                        .gradoRareza("Común")
                        .build(),

                Material.builder()
                        .nombre("Cuerno de Moblin")
                        .categoria("Parte de Monstruo")
                        .efectoAlCocinar("Ataque")
                        .precioVentaEnRupias(25)
                        .ubicacionPrincipal("Desierto Gerudo")
                        .gradoRareza("Poco Común")
                        .build(),

                Material.builder()
                        .nombre("Fragmento de Estrella")
                        .categoria("Mineral")
                        .efectoAlCocinar("Corazones")
                        .precioVentaEnRupias(300)
                        .ubicacionPrincipal("Llanura de Hyrule")
                        .gradoRareza("Legendario")
                        .build()
        );
    }
}
