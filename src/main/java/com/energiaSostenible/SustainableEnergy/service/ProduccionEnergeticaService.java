
package com.energiaSostenible.SustainableEnergy.service;


import com.energiaSostenible.SustainableEnergy.model.ProduccionEnergetica;
import com.energiaSostenible.SustainableEnergy.repository.ProduccionEnergeticaRepository;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProduccionEnergeticaService {

    @Autowired
    private ProduccionEnergeticaRepository produccionEnergeticaRepository;

    public List<ProduccionEnergetica> obtenerPorNombre(String pais) {
        return produccionEnergeticaRepository.findByPais(pais);
    }

    public List<ProduccionEnergetica> obtenertodo() {
        return produccionEnergeticaRepository.findAll();
    }

    public List<Map<String, Object>> formatearProduccionPorFuenteYRegion(String year) {
        List<Object[]> rawData = produccionEnergeticaRepository.obtenerProduccionPorFuenteYRegion(year);
        List<Map<String, Object>> formattedData = new ArrayList<>();
        for (Object[] row : rawData) {
            Map<String, Object> data = new HashMap<>();
            data.put("fuenteDeEnergia", row[0]);
            data.put("produccion", row[1]);
            data.put("pais", row[2]);
            formattedData.add(data);
        }
        return formattedData;
    }

    public List<Map<String, Object>> formatearPorcentajeEnergiaRenovable(String year, Double consumoTotal) {
        List<Object[]> rawData = produccionEnergeticaRepository.calcularPorcentajeEnergiaRenovable(year, consumoTotal);
        List<Map<String, Object>> formattedData = new ArrayList<>();
        for (Object[] row : rawData) {
            Map<String, Object> data = new HashMap<>();
            data.put("pais", row[0]);
            data.put("energiaRenovable", row[1]);
            data.put("porcentaje", row[2]);
            formattedData.add(data);
        }
        return formattedData;
    }

     public List<Map<String, Object>> obtenerTendenciaCapacidadSolar() {
        List<Object[]> rawData = produccionEnergeticaRepository.obtenerTendenciaCapacidadSolar();

        List<Map<String, Object>> formattedData = new ArrayList<>();
        for (Object[] row : rawData) {
            Map<String, Object> data = new HashMap<>();
            data.put("year", row[0]);
            data.put("produccion", row[1]);
            formattedData.add(data);
        }
        return formattedData;
    }

     public List<Map<String, Object>> formatearTop10PaisesEolica(String year) {
        List<Object[]> rawData = produccionEnergeticaRepository.obtenerTop10PaisesEolica(year);

        List<Map<String, Object>> formattedData = new ArrayList<>();
        for (Object[] row : rawData) {
            Map<String, Object> data = new HashMap<>();
            data.put("pais", row[0]);
            data.put("produccion", row[1]);
            formattedData.add(data);
        }
        return formattedData;
    }

    public List<Map<String, Object>> formatearFuentesYPaticipacion() {
        List<Object[]> rawData = produccionEnergeticaRepository.listarFuentesYPaticipacion();
        List<Map<String, Object>> formattedData = new ArrayList<>();
        for (Object[] row : rawData) {
            Map<String, Object> data = new HashMap<>();
            data.put("fuenteDeEnergia", row[0]);
            data.put("produccion", row[1]);
            data.put("participacion", row[2]);
            formattedData.add(data);
        }
        return formattedData;
    }
}
