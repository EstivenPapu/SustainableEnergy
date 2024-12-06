
package com.energiaSostenible.SustainableEnergy.controller;

import com.energiaSostenible.SustainableEnergy.service.ProduccionEnergeticaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produccion")
public class ProduccionEnergeticaController {

    @Autowired
    private ProduccionEnergeticaService produccionEnergeticaService;

    // 1. Producción total por tipo de fuente en un año específico, agrupada por regiones
    @GetMapping("/por-fuente-y-region")
    public List<Object[]> obtenerProduccionPorFuenteYRegion(@RequestParam String year) {
        return produccionEnergeticaService.obtenerProduccionPorFuenteYRegion(year);
    }

    // 2. Porcentaje de energía renovable en el consumo total de cada región                       
    @GetMapping("/porcentaje-renovable")
    public List<Object[]> calcularPorcentajeEnergiaRenovable(
            @RequestParam String year,
            @RequestParam Double consumoTotal) {
        return produccionEnergeticaService.calcularPorcentajeEnergiaRenovable(year, consumoTotal);
    }

    // 3. Tendencia de capacidad instalada de energía solar
    @GetMapping("/tendencia-solar")
    public List<Object[]> obtenerTendenciaCapacidadSolar() {
        return produccionEnergeticaService.obtenerTendenciaCapacidadSolar();
    }

    // 4. Top 10 países con mayor producción de energía eólica
    @GetMapping("/top-paises-eolica")
    public List<Object[]> obtenerTop10PaisesEolica(@RequestParam String year) {
        return produccionEnergeticaService.obtenerTop10PaisesEolica(year);
    }

    
    // 5. Listar todas las fuentes y su participación global
    @GetMapping("/fuentes-participacion")
    public List<Object[]> listarFuentesYPaticipacion() {
        return produccionEnergeticaService.listarFuentesYPaticipacion();
    }
}
  