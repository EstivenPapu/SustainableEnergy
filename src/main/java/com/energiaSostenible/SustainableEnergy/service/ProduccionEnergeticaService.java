
package com.energiaSostenible.SustainableEnergy.service;


import com.energiaSostenible.SustainableEnergy.repository.ProduccionEnergeticaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduccionEnergeticaService {
    
   
    @Autowired
    private ProduccionEnergeticaRepository produccionEnergeticaRepository;

    // 1. Producción total por tipo de fuente en un año específico, agrupada por regiones
    public List<Object[]> obtenerProduccionPorFuenteYRegion(String year) {
        return produccionEnergeticaRepository.obtenerProduccionPorFuenteYRegion(year);
    }

    // 2. Porcentaje de energía renovable en el consumo total de cada región
    public List<Object[]> calcularPorcentajeEnergiaRenovable(String year, Double consumoTotal) {
        return produccionEnergeticaRepository.calcularPorcentajeEnergiaRenovable(year, consumoTotal);
    }

    // 3. Tendencia de capacidad instalada de energía solar
    public List<Object[]> obtenerTendenciaCapacidadSolar() {
        return produccionEnergeticaRepository.obtenerTendenciaCapacidadSolar();
    }

    // 4. Top 10 países con mayor producción de energía eólica
    public List<Object[]> obtenerTop10PaisesEolica(String year) {
        return produccionEnergeticaRepository.obtenerTop10PaisesEolica(year);
    }

    // 5. Listar todas las fuentes y su participación global
    public List<Object[]> listarFuentesYPaticipacion() {
        return produccionEnergeticaRepository.listarFuentesYPaticipacion();
    }
}
