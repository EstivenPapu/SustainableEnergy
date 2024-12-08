
package com.energiaSostenible.SustainableEnergy.controller;

import com.energiaSostenible.SustainableEnergy.model.ProduccionEnergetica;
import com.energiaSostenible.SustainableEnergy.service.ProduccionEnergeticaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produccion")
public class ProduccionEnergeticaController {

    @Autowired
    private ProduccionEnergeticaService produccionEnergeticaService;

    @GetMapping()
    public List<ProduccionEnergetica> obtenerTodosLosDatos() {
        return produccionEnergeticaService.obtenertodo();
    }

    @GetMapping("/por-fuente-y-region")
    public List<Map<String, Object>> obtenerProduccionPorFuenteYRegion(@RequestParam String year) {
        return produccionEnergeticaService.formatearProduccionPorFuenteYRegion(year);
    }

    @GetMapping("/nombre")
    public List<ProduccionEnergetica> obtenerPorNombre(@RequestParam String nombre) {
        return produccionEnergeticaService.obtenerPorNombre(nombre);
    }

    @GetMapping("/porcentaje-renovable")
    public List<Map<String, Object>> calcularPorcentajeEnergiaRenovable(
            @RequestParam String year, 
            @RequestParam Double consumoTotal) {
        return produccionEnergeticaService.formatearPorcentajeEnergiaRenovable(year, consumoTotal);
    }

    @GetMapping("/tendencia-solar")
    public List<Map<String, Object>> obtenerTendenciaCapacidadSolar() {
        return produccionEnergeticaService.obtenerTendenciaCapacidadSolar();
    }

    @GetMapping("/top-paises-eolica")
    public List<Map<String, Object>> obtenerTop10PaisesEolica(@RequestParam String year) {
        return produccionEnergeticaService.formatearTop10PaisesEolica(year);
    }

    @GetMapping("/fuentes-participacion")
    public List<Map<String, Object>> listarFuentesYPaticipacion() {
        return produccionEnergeticaService.formatearFuentesYPaticipacion();
    }
}
